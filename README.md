# disruptor-benchmark-tests
Benchmark tests for LMAX Disruptor – a High Performance Inter-thread Messaging Library
based on a ring buffer written using Java LMAX Disruptor implementation and JMH for Java Microbenchmarking.

# Running
- Build application
> ```mvn clean install```

- Run application
> ```java -classpath target/microbenchmarks.jar com.disruptor.benchmark.DisruptorBenchmarks```

Use `java -jar target/benchmarks.jar -h` command to see all available command line options.

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

## 1 thread configuration. 1 MLN events - 1 operation

| "Benchmark"                                                       | "Mode"  | "Threads" | "Samples" | "Score"   | "Score Error (99.9%)" | "Unit"  | "Param: producerType" | "Param: ringBufferSize" | "Param: waitStrategy"                       |
|-------------------------------------------------------------------|---------|-----------|-----------|-----------|-----------------------|---------|-----------------------|-------------------------|---------------------------------------------|
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 34.613624 | 3.275514              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 14.793899 | 1.667806              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 52.767722 | 1.179461              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 64.723893 | 0.984595              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 52.985426 | 0.518072              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 42.743035 | 8.159788              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 11.444324 | 0.277379              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 98.055555 | 1.666037              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 96.702789 | 1.838246              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 97.088225 | 1.338768              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 24.119363 | 0.272235              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 14.346598 | 1.990403              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 21.391328 | 1.681176              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 20.780078 | 3.189916              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 21.654601 | 0.722790              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 28.571950 | 3.570424              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 13.630005 | 0.474532              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 22.156572 | 0.864452              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 22.456525 | 1.335810              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 1         | 10        | 22.102795 | 1.033668              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |

## 4 threads configuration. 1 MLN events - 1 operation

| "Benchmark"                                                       | "Mode"  | "Threads" | "Samples" | "Score"    | "Score Error (99.9%)" | "Unit"  | "Param: producerType" | "Param: ringBufferSize" | "Param: waitStrategy"                       |
|-------------------------------------------------------------------|---------|-----------|-----------|------------|-----------------------|---------|-----------------------|-------------------------|---------------------------------------------|
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 98.061792  | 2.667661              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 36.660002  | 4.716313              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 192.325774 | 3.399981              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 277.390375 | 30.143209             | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 203.703161 | 5.113300              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 87.196474  | 4.236982              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 41.374392  | 4.045487              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 278.965528 | 5.900127              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 329.198944 | 41.876241             | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 276.683810 | 4.493385              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 73.407980  | 3.476870              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 30.159254  | 0.277190              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 85.419684  | 3.394856              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 108.781826 | 25.300872             | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 85.742898  | 3.246401              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 63.463764  | 2.280752              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 30.065181  | 1.146206              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 101.341292 | 10.704500             | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 126.480073 | 29.450960             | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.processOneMlnEvents" | "thrpt" | 4         | 10        | 109.441823 | 8.170063              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
