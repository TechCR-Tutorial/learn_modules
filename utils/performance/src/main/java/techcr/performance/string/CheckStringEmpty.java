package techcr.performance.string;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1)
public class CheckStringEmpty {

    @Param({"", "nonEmptyString"})
    private String strParams;

    @Benchmark
    public boolean nonNullAndIsEmpty() {
        return strParams != null && strParams.isEmpty();
    }

    @Benchmark
    public boolean equalsPost() {
        return strParams != null && strParams.equals("");
    }

    @Benchmark
    public boolean preEquals() {
        return "".equals(strParams);
    }


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
            .include(CheckStringEmpty.class.getSimpleName())
            .forks(1)
            .build();

        new Runner(opt).run();
    }
}
