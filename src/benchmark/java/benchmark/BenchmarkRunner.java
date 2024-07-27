package benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import playgroundbenchmark.playground1benchmark;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
            .include(playground1benchmark.class.getSimpleName())
            .forks(1)
            .threads(4)
            .output("testCount.txt")
            .build();
        
        new Runner(opt).run();
    }
}