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

| "Benchmark"                                                  | "Mode"  | "Threads" | "Samples" | "Score"  | "Score Error (99.9%)" | "Unit"  | "Param: producerType" | "Param: ringBufferSize" | "Param: waitStrategy"                       |
|--------------------------------------------------------------|---------|-----------|-----------|----------|-----------------------|---------|-----------------------|-------------------------|---------------------------------------------|
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 1.086972 | 0.030665              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.431770 | 0.001905              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.961749 | 0.006709              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 1.745486 | 0.010473              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.958971 | 0.011178              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 1.219747 | 0.014065              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.330560 | 0.043571              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 1.755311 | 0.033513              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 2.706115 | 0.096820              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 1.803689 | 0.040058              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 1.811797 | 0.119222              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.364585 | 0.017678              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 3.329902 | 0.100152              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 3.955564 | 0.022034              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 3.298320 | 0.084069              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.656924 | 0.040255              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.390862 | 0.019560              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.740740 | 0.029269              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.703116 | 0.059925              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.737952 | 0.024351              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.751929 | 0.237823              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.418815 | 0.012293              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.737197 | 0.033828              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.724977 | 0.057171              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.726034 | 0.051968              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.862917 | 0.134444              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.439024 | 0.023502              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.738794 | 0.045997              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.703142 | 0.062489              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 1         | 10        | 0.749100 | 0.028278              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 4.192916 | 0.107364              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 1.164312 | 0.009766              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 3.953520 | 0.058501              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 6.176508 | 0.516413              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 4.015082 | 0.069162              | "ops/s" | SINGLE                | 512                     | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 3.590424 | 0.112368              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 1.461800 | 0.013071              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 6.503329 | 0.126713              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 8.970220 | 0.662070              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 6.606112 | 0.073768              | "ops/s" | SINGLE                | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 7.904464 | 0.719358              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 1.118617 | 0.009013              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 9.390132 | 0.177599              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 5.050642 | 0.539362              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 9.548165 | 0.155137              | "ops/s" | SINGLE                | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 2.148960 | 0.078190              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 0.928514 | 0.013507              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 2.755478 | 0.056248              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 3.834875 | 0.444720              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 2.719405 | 0.081346              | "ops/s" | MULTI                 | 512                     | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 2.244469 | 0.199279              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 1.072457 | 0.016834              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 2.869614 | 0.102634              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 5.583515 | 0.423010              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 3.120569 | 0.086570              | "ops/s" | MULTI                 | 1024                    | com.lmax.disruptor.YieldingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 2.562148 | 0.039929              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.LiteBlockingWaitStrategy |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 1.060365 | 0.024271              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BlockingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 6.466247 | 0.213092              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.SleepingWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 3.589961 | 0.564760              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.BusySpinWaitStrategy     |
| "com.disruptor.benchmark.DisruptorBenchmarks.generateEvents" | "thrpt" | 4         | 10        | 3.774458 | 0.239124              | "ops/s" | MULTI                 | 2048                    | com.lmax.disruptor.YieldingWaitStrategy     |
