package dowhile.my;

import java.util.Optional;

/**
 * Created by chamly on 7/5/2017.
 */
@FunctionalInterface
public interface NextProvidble<T> {

    Optional<T> next();
}
