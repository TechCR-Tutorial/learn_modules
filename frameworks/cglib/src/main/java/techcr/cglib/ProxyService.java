package techcr.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.Mixin;

import net.sf.cglib.beans.BeanGenerator;

public class ProxyService {


    public static void main(String[] args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        printSameValue();
        printValueDependOnMethodSignature();
        beanCreator();
        mixinExample();
    }

    private static void beanCreator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        Method getter = myBean.getClass().getMethod("getName");
        System.out.println(getter.invoke(myBean));

    }

    private static void printValueDependOnMethodSignature() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello TechCR!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });

        PersonService proxy = (PersonService) enhancer.create();
        int lengthOfName = proxy.lengthOfName("MyString");
        System.out.println("Based On method signature: Length: " + lengthOfName);
        System.out.println("Based On method signature: Name: " + proxy.sayHello(null));
    }

    private static void printSameValue() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello TechCR!");
        PersonService proxy = (PersonService) enhancer.create();

        String res = proxy.sayHello(null);
        System.out.println(res);
    }


    private static void mixinExample() {
        Mixin mixin = Mixin.create(
            new Class[]{ Interface1.class, Interface2.class, MixinInterface.class },
            new Object[]{ new Class1(), new Class2() }
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        System.out.println(mixinDelegate.first());
        System.out.println(mixinDelegate.second());
    }

    public interface MixinInterface extends Interface1, Interface2 { }

    public interface Interface1 {
        String first();
    }

    public interface Interface2 {
        String second();
    }

    public static class Class1 implements Interface1 {
        @Override
        public String first() {
            return "first behaviour";
        }
    }

    public static class Class2 implements Interface2 {
        @Override
        public String second() {
            return "second behaviour";
        }
    }
}
