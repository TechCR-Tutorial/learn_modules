package dowhile.lakmini2;

import java.util.Optional;

public abstract class CustomDoWhile<T extends CustomDoWhileInterface<T>> {

    public void operate(T customType) {
       // doThis(customType);
        doSomething(customType);
        Optional<T> nextValue = customType.nextValue();
        nextValue.ifPresent(this::operate);
    }
    void doThis(T customTypeInt) {
        System.out.println(customTypeInt.toString());
    }
    abstract void doSomething(T customTypeInt);
}
