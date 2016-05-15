# disruptor-benchmark-tests
Benchmark tests for LMAX Disruptor – a High Performance Inter-thread Messaging Library
based on a ring buffer written using Java LMAX Disruptor implementation and JMH for Java Microbenchmarking.

# Running
- > ```mvn clean install```
- > ```java -classpath target/microbenchmarks.jar com.disruptor.benchmark.DisruptorBenchmarks```

Use `java -jar target/benchmarks.jar -h` command to see all available command line options.

# Resources
- [Using the Disruptor](https://github.com/LMAX-Exchange/disruptor/wiki)
- [Inter-thread communications in Java at the speed of light](http://www.infoq.com/articles/High-Performance-Java-Inter-Thread-Communications)
- [Code Tools: jmh](http://openjdk.java.net/projects/code-tools/jmh/)
- [Introduction to JMH](http://java-performance.info/jmh/)