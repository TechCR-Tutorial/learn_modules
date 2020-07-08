package dowhile.nuwan;

import java.util.Objects;
import java.util.function.Predicate;

public class CustomDoWhile<T>  {
    void operate(DataObj<? extends T> d, DoWhileConsumer<T> func, Predicate<T> p){
        Objects.isNull(d);
        Objects.isNull(func);
        T newData = d.value();
        do{
            newData = func.accept(newData);
        } while(p.test(newData));
    }

    /**
     * SOLID principles.
     * CustomDoWhile not responsible to return next value.
     * @param args
     */

    public static void main(String [] args){
        //new ArrayList<String>().stream().filter()
        new CustomDoWhile<Integer>().operate(() -> 0,
                (value) -> {
                    System.out.println(++value);
                    return value;

                }, (integer) -> integer < 3 && integer <2);
    }
}
