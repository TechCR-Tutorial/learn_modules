package dowhile.lakmini2;

public class Main {

    public static void main(String[] args) {
        CustomDoWhile<CustomTypeInt> customTypeIntCustomDoWhile = new CustomDoWhile<CustomTypeInt>() {
            @Override
            void doSomething(CustomTypeInt customTypeInt) {
                System.out.println(customTypeInt.toString());
            }
        };
       customTypeIntCustomDoWhile.operate(new CustomTypeInt(1));
    }
}
