package dowhile;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by chamly on 7/5/2017.
 */
public class CustomDoWhileMain {

    public static void main(String[] args) {
        new CustomDoWhile<Item>().operate(new NextProvidble<Item>() {
            int nr;
            @Override
            public Optional<Item> next() {
                return nr < 10 ? Optional.of(new Item(nr++)) : Optional.empty();
            }
        }, item -> System.out.println(item.toString()));

        testList();
    }

    private static void testList() {
        List<Integer> countList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        new CustomDoWhile<Item>().operate(new NextProvidble<Item>() {
            int nr;
            @Override
            public Optional<Item> next() {
                return nr == countList.size() ? Optional.empty() : Optional.of(new Item(countList.get(nr++)));
            }
        }, item -> System.out.println("count is " + item.toString()));
    }
}
