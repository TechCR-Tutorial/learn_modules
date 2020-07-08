package dowhile.lakmini;

import java.util.Optional;

public class CustomDoWhile<T extends CustomDoWhileInterface<T>> {

    public void operate(T customType) {
        System.out.println(customType.toString());
        Optional<T> nextValue = customType.nextValue();
        nextValue.ifPresent(this::operate);
    }
}
