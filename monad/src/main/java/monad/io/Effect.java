package monad.io;

@FunctionalInterface
public interface Effect<T> {
    T run();
}
