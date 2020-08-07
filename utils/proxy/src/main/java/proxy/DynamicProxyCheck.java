package proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxyCheck implements InvocationHandler {

    public Map<String, Executor> executorMap = new HashMap<>();

    public DynamicProxyCheck(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("add")) {
                executorMap.put(methodName, createExecutor(methodName.substring(3), OperationType.ADD));
            } else if (methodName.startsWith("minus")) {
                executorMap.put(methodName, createExecutor(methodName.substring(5), OperationType.MINUS));
            }
        }
    }

    private Executor createExecutor(String clause, OperationType type) {
        int byValue = Integer.parseInt(clause.substring(clause.length() -1));
        String dependantField = clause.substring(0, clause.length() -1).toLowerCase();
        return new Executor(byValue, dependantField, type);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object object = args[0];
        Executor executor = executorMap.get(method.getName());
        Field field = object.getClass().getDeclaredField(executor.dependField);
        field.setAccessible(true);
        int valueTwo = (int) field.get(object);

        return executor.execute(valueTwo);
    }


    public static void main(String[] args) {
        MyInterface instance = (MyInterface) Proxy
            .newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[] { MyInterface.class }, new DynamicProxyCheck(MyInterface.class));
        Person person = new Person("Chamly", 35);
        System.out.println("Add Result: " + instance.addAge1(person));
        System.out.println("Minus Result: " + instance.minusAge1(person));

        Person salaryPerson = new Person("Salary Person", 35, 10);
        System.out.println("Add Salary: " + instance.addSalary5(salaryPerson));
        System.out.println("Minus Salary: " + instance.minusSalary3(salaryPerson));

        MyCartInterface cartInterface = (MyCartInterface) Proxy
            .newProxyInstance(MyCartInterface.class.getClassLoader(),
                new Class[] { MyCartInterface.class }, new DynamicProxyCheck(MyCartInterface.class));

        MyCart cart = new MyCart(10, 20);
        System.out.println("Add Amount " + cartInterface.addAmount5(cart));
        System.out.println("Add Items " + cartInterface.addItems1(cart));

    }


    public class Executor {
        int valueTwo;
        String dependField;
        OperationType type;

        public Executor(int valueTwo, String dependField, OperationType type) {
            this.valueTwo = valueTwo;
            this.dependField = dependField;
            this.type = type;
        }

        int execute(int valueOne) {
            return type.doOperate(valueOne, valueTwo);
        }
    }

    public enum OperationType {
        ADD {
            @Override
            public int doOperate(int valueOne, int valueTwo) {
                return valueOne + valueTwo;
            }
        },
        MINUS {
            @Override
            public int doOperate(int valueOne, int valueTwo) {
                return valueOne - valueTwo;
            }
        };

        public abstract int doOperate(int valueOne, int valueTwo);
    }
}
