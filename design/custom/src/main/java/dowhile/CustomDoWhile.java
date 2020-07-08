package dowhile;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by chamly on 7/5/2017.
 */
public class CustomDoWhile<T> {

    public void operate(NextProvidble<T> nextProvider, Consumer<T> tConsumer) {
        Optional<T> next = nextProvider.next();
        next.ifPresent(nextT -> {
            tConsumer.accept(nextT);
            operate(nextProvider, tConsumer);
        });

//        Optional<T> next2;
//        while ((next2 = nextProvider.next()).isPresent()) {
//            tConsumer.accept(next2.get());
//        }
    }
}
