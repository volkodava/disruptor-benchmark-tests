package com.disruptor.benchmark;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@State(Scope.Thread)
public class DisruptorBenchmarks {

    private EventHandler<LongEvent> handler;
    private Disruptor<LongEvent> disruptor;
    private RingBuffer<LongEvent> ringBuffer;
    private AtomicInteger eventCount;

    @Param({"1024", "2048"})
    String ringBufferSize;
    @Param({"SINGLE", "MULTI"})
    String producerType;
    @Param({"com.lmax.disruptor.LiteBlockingWaitStrategy",
            "com.lmax.disruptor.BlockingWaitStrategy", "com.lmax.disruptor.SleepingWaitStrategy",
            "com.lmax.disruptor.BusySpinWaitStrategy", "com.lmax.disruptor.YieldingWaitStrategy",})
    String waitStrategy;

    @Setup
    public void setup() throws Exception {
        disruptor = new Disruptor<LongEvent>(LongEvent.EVENT_FACTORY, Integer.valueOf(ringBufferSize),
                DaemonThreadFactory.INSTANCE, ProducerType.valueOf(producerType),
                createWaitStrategyInstance(waitStrategy));
        eventCount = new AtomicInteger();

        handler = new EventHandler<LongEvent>() {
            public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
                if (Configuration.VALUE == event.getValue()) {
                    eventCount.incrementAndGet();
                } else {
                    throw new IllegalStateException("Expected: " + Configuration.VALUE +
                            ". Actual: " + event.getValue());
                }
            }
        };

        disruptor.handleEventsWith(handler);

        ringBuffer = disruptor.start();
    }

    @TearDown
    public void tearDown() {
        disruptor.shutdown();
    }

    private WaitStrategy createWaitStrategyInstance(String clsName) throws Exception {
        Class<WaitStrategy> clazz = (Class<WaitStrategy>) Class.forName(clsName);
        return clazz.newInstance();
    }

    @Benchmark
    public void processOneMlnEvents() {
        final int ONE_MLN = 1000000;

        for (int i = 0; i < ONE_MLN; i++) {
            ringBuffer.publishEvent(LongEvent.EVENT_TRANSLATOR, Configuration.VALUE);
        }

        while (eventCount.get() < ONE_MLN) {
            Thread.yield();
        }
    }

    private static final class LongEvent {
        private long value = -1L;

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public final static EventFactory<LongEvent> EVENT_FACTORY = new EventFactory<DisruptorBenchmarks.LongEvent>() {
            @Override
            public DisruptorBenchmarks.LongEvent newInstance() {
                return new DisruptorBenchmarks.LongEvent();
            }
        };

        public static final EventTranslatorOneArg<LongEvent, Long> EVENT_TRANSLATOR =
                new EventTranslatorOneArg<DisruptorBenchmarks.LongEvent, Long>() {
                    @Override
                    public void translateTo(DisruptorBenchmarks.LongEvent event, long sequence, Long value) {
                        event.setValue(value);
                    }
                };
    }

    public static void main(String[] args) throws Exception {
        int[] threadConfigurations = {1, 4};

        for (int numOfThreads : threadConfigurations) {
            // run benchmarks with specific number of threads
            runBenchmarks(numOfThreads);
        }
    }

    private static void runBenchmarks(int numOfThreads) throws Exception {
        final String resultFileName = "threads_x" + numOfThreads + ".csv";

        Options opts = new OptionsBuilder()
                .include(".*" + DisruptorBenchmarks.class.getSimpleName() + ".*")
                .forks(Configuration.FORKS)
                .threads(numOfThreads)
                .jvmArgs("-server", "-Xms2048m", "-Xmx2048m")
                .mode(Mode.Throughput)
                .timeUnit(TimeUnit.SECONDS)
                .warmupIterations(Configuration.WARMUP_ITERATIONS)
                .measurementIterations(Configuration.MEASUREMENT_ITERATIONS)
                // Use this to selectively constrain/override parameters
                // .param("ringBufferSize", "256", "512", "1024", "2048", "4096")
                .resultFormat(ResultFormatType.CSV)
                .result(resultFileName)
                .build();

        new Runner(opts).run();
    }
}
