package monad.io;

import java.util.function.Consumer;
import java.util.function.Function;

public class IO<A> {

    private final Effect<A> effect;

    private IO(Effect<A> effect) {
        this.effect = effect;
    }

    public A unsafeRun() {
        return effect.run();
    }

    public <B> IO<B> flatMap(Function<A, IO<B>> function) {
        return function.apply(unsafeRun());
//        return IO.apply(() -> function.apply(unsafeRun()).unsafeRun());
    }

    public <B> IO<B> map(Function<A, B> function) {
        return this.flatMap(result -> IO.apply(() -> function.apply(result)));
    }

    public static <T> IO<T> apply(Effect<T> effect) {
        return new IO<>(effect);
    }

    public IO<Void> mapToVoid(Consumer<A> function) {
        return this.flatMap(result -> IO.apply(() -> {
            function.accept(result);
            //We can’t instantiate Void, hence we can return null only
            return null;
        }));
    }

    public static void main(String[] args) {
        System.out.println("Running........");
        Effect effect = () -> "Chamly Effect";
        System.out.println(effect.run());


        IO.apply(() -> "abc")
            .map(String::toUpperCase)
            .mapToVoid(System.out::println)
            .unsafeRun();

        IO.apply(() -> "What is your name friend?")
            .mapToVoid(System.out::println)
            .map(ignored -> System.console().readLine())
//            .map(ignored -> "Chamly")
            .map(name -> String.format("Hello %s !", name))
            .mapToVoid(System.out::println)
            .unsafeRun();


        System.out.println("Completed........");
    }
}
