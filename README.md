# disruptor-benchmark-tests
Benchmark tests for LMAX Disruptor – a High Performance Inter-thread Messaging Library
based on a ring buffer written using Java LMAX Disruptor implementation and JMH for Java Microbenchmarking.

# Running
- Build application
> ```mvn clean install```

- Run application
> ```java -classpath target/microbenchmarks.jar com.disruptor.benchmark.DisruptorBenchmarks```

# Resources
- [Using the Disruptor](https://github.com/LMAX-Exchange/disruptor/wiki)
- [Inter-thread communications in Java at the speed of light](http://www.infoq.com/articles/High-Performance-Java-Inter-Thread-Communications)
- [Code Tools: jmh](http://openjdk.java.net/projects/code-tools/jmh/)
- [Introduction to JMH](http://java-performance.info/jmh/)

# Results
These tests were run on

- JMH 1.12 (released 45 days ago)
- VM version: JDK 1.8.0_91, VM 25.91-b14
- VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_91.jdk/Contents/Home/jre/bin/java
- VM options: -server -Xms2048m -Xmx2048m

| Parameter             | Value         |
|-----------------------|---------------|
| Model Name            | MacBook Pro   |
| Processor Name        | Intel Core i7 |
| Processor Speed       | 2,5 GHz       |
| Number of Processors  | 1             |
| Total Number of Cores | 4             |
| L2 Cache (per Core)   | 256 KB        |
| L3 Cache              | 6 MB          |
| Memory                | 16 GB         |

Here are the benchmark results for `com.lmax:disruptor:3.3.4`

## Throughput: 1 ops/s = 1 MLN events/sec, 1 thread configuration

| Score     | Unit  | Threads | waitStrategy                                | producerType | ringBufferSize |
|-----------|-------|---------|---------------------------------------------|--------------|----------------|
| 98.055555 | ops/s | 1       | com.lmax.disruptor.SleepingWaitStrategy     | SINGLE       | 2048           |
| 97.088225 | ops/s | 1       | com.lmax.disruptor.YieldingWaitStrategy     | SINGLE       | 2048           |
| 96.702789 | ops/s | 1       | com.lmax.disruptor.BusySpinWaitStrategy     | SINGLE       | 2048           |
| 64.723893 | ops/s | 1       | com.lmax.disruptor.BusySpinWaitStrategy     | SINGLE       | 1024           |
| 52.985426 | ops/s | 1       | com.lmax.disruptor.YieldingWaitStrategy     | SINGLE       | 1024           |
| 52.767722 | ops/s | 1       | com.lmax.disruptor.SleepingWaitStrategy     | SINGLE       | 1024           |
| 42.743035 | ops/s | 1       | com.lmax.disruptor.LiteBlockingWaitStrategy | SINGLE       | 2048           |
| 34.613624 | ops/s | 1       | com.lmax.disruptor.LiteBlockingWaitStrategy | SINGLE       | 1024           |
| 28.57195  | ops/s | 1       | com.lmax.disruptor.LiteBlockingWaitStrategy | MULTI        | 2048           |
| 24.119363 | ops/s | 1       | com.lmax.disruptor.LiteBlockingWaitStrategy | MULTI        | 1024           |
| 22.456525 | ops/s | 1       | com.lmax.disruptor.BusySpinWaitStrategy     | MULTI        | 2048           |
| 22.156572 | ops/s | 1       | com.lmax.disruptor.SleepingWaitStrategy     | MULTI        | 2048           |
| 22.102795 | ops/s | 1       | com.lmax.disruptor.YieldingWaitStrategy     | MULTI        | 2048           |
| 21.654601 | ops/s | 1       | com.lmax.disruptor.YieldingWaitStrategy     | MULTI        | 1024           |
| 21.391328 | ops/s | 1       | com.lmax.disruptor.SleepingWaitStrategy     | MULTI        | 1024           |
| 20.780078 | ops/s | 1       | com.lmax.disruptor.BusySpinWaitStrategy     | MULTI        | 1024           |
| 14.793899 | ops/s | 1       | com.lmax.disruptor.BlockingWaitStrategy     | SINGLE       | 1024           |
| 14.346598 | ops/s | 1       | com.lmax.disruptor.BlockingWaitStrategy     | MULTI        | 1024           |
| 13.630005 | ops/s | 1       | com.lmax.disruptor.BlockingWaitStrategy     | MULTI        | 2048           |
| 11.444324 | ops/s | 1       | com.lmax.disruptor.BlockingWaitStrategy     | SINGLE       | 2048           |

## Throughput: 1 ops/s = 1 MLN events/sec, 4 threads configuration

| Score      | Unit  | Threads | waitStrategy                                | producerType | ringBufferSize |
|------------|-------|---------|---------------------------------------------|--------------|----------------|
| 329.198944 | ops/s | 4       | com.lmax.disruptor.BusySpinWaitStrategy     | SINGLE       | 2048           |
| 278.965528 | ops/s | 4       | com.lmax.disruptor.SleepingWaitStrategy     | SINGLE       | 2048           |
| 277.390375 | ops/s | 4       | com.lmax.disruptor.BusySpinWaitStrategy     | SINGLE       | 1024           |
| 276.68381  | ops/s | 4       | com.lmax.disruptor.YieldingWaitStrategy     | SINGLE       | 2048           |
| 203.703161 | ops/s | 4       | com.lmax.disruptor.YieldingWaitStrategy     | SINGLE       | 1024           |
| 192.325774 | ops/s | 4       | com.lmax.disruptor.SleepingWaitStrategy     | SINGLE       | 1024           |
| 126.480073 | ops/s | 4       | com.lmax.disruptor.BusySpinWaitStrategy     | MULTI        | 2048           |
| 109.441823 | ops/s | 4       | com.lmax.disruptor.YieldingWaitStrategy     | MULTI        | 2048           |
| 108.781826 | ops/s | 4       | com.lmax.disruptor.BusySpinWaitStrategy     | MULTI        | 1024           |
| 101.341292 | ops/s | 4       | com.lmax.disruptor.SleepingWaitStrategy     | MULTI        | 2048           |
| 98.061792  | ops/s | 4       | com.lmax.disruptor.LiteBlockingWaitStrategy | SINGLE       | 1024           |
| 87.196474  | ops/s | 4       | com.lmax.disruptor.LiteBlockingWaitStrategy | SINGLE       | 2048           |
| 85.742898  | ops/s | 4       | com.lmax.disruptor.YieldingWaitStrategy     | MULTI        | 1024           |
| 85.419684  | ops/s | 4       | com.lmax.disruptor.SleepingWaitStrategy     | MULTI        | 1024           |
| 73.40798   | ops/s | 4       | com.lmax.disruptor.LiteBlockingWaitStrategy | MULTI        | 1024           |
| 63.463764  | ops/s | 4       | com.lmax.disruptor.LiteBlockingWaitStrategy | MULTI        | 2048           |
| 41.374392  | ops/s | 4       | com.lmax.disruptor.BlockingWaitStrategy     | SINGLE       | 2048           |
| 36.660002  | ops/s | 4       | com.lmax.disruptor.BlockingWaitStrategy     | SINGLE       | 1024           |
| 30.159254  | ops/s | 4       | com.lmax.disruptor.BlockingWaitStrategy     | MULTI        | 1024           |
| 30.065181  | ops/s | 4       | com.lmax.disruptor.BlockingWaitStrategy     | MULTI        | 2048           |

* Reports build with &copy; [csvkit](http://csvkit.readthedocs.io/en/0.9.1/index.html)
