package chapter09;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class T01_Lambda
{
    @Test
    public void test1(){
        //普通写法
        PrintStream ps = System.out;
        Consumer<String>con = (x) -> ps.println(x);
        con.accept("hello !");

        System.out.println("----------------------");
        //简写
        Consumer<String>con1 = ps::println;
        con1.accept("hello ! ");

        System.out.println("----------------------");
        //更简单的写法
        Consumer<String>con2 = System.out::println;
        con2.accept("hello ! ");
    }

    @Test
    public void test2(){

        // method 1
        Consumer<String> consumer = s -> System.out.println(s);
        useConsumer(consumer,"123");

        //method 2
        useConsumer(s -> System.out.println(s),"123");

        //method3   method reference (方法引用)
        useConsumer(System.out::println,"123"); //因为println和 accept 是同样的只有一个入参，没有返回值
    }

    public static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
    }

    @Test
    public void test3()
    {
        Employee emp = new Employee("zx",23);

        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        //简写
        Supplier<String>sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    public static int add(int a,int b)
    {
        return a+b;
    }

    public interface Plus
    {
        int plus(int a,int b);
    }

    @Test
    public void test4()
    {
        Plus p = T01_Lambda::add;
        System.out.println(p.plus(10,28));

    }

    class Dance
    {
        String danceType;

        public Dance(String danceType)
        {
            this.danceType = danceType;
        }

        public void display(String dancer)
        {
            System.out.println(dancer+"跳"+danceType);
        }
    }

    public interface Show
    {
        void show(Dance dance,String danceType);
    }

    @Test
    public void test5()
    {
        Show show = Dance::display;
        show.show(new Dance("mv"),"wu");
    }

    @Test
    public void test6()
    {
        BiFunction<String,Integer,Character> bf = String::charAt; //这里第一个必须传入　String
        Character c = bf.apply("hello,", 2);
        System.out.println(c);

        //注意这里使用的是Function 接口
        String str = new String("hello");
        Function<Integer,Character> f = str::charAt; //这里不需要String
        Character c2 = f.apply(2);
        System.out.println(c2);

    }

    @Test
    public void test7()
    {
        Consumer<String> consumer = Employee::new;
        consumer.accept("dd");

        Supplier<Employee> supplier = Employee::new;
        System.out.println(supplier.get());

        Function<String,Employee> function = Employee::new;
        System.out.println(function.apply("haode"));

        BiFunction<String,Integer,Employee> biFunction = Employee::new;
        System.out.println(biFunction.apply("wu",98));

    }

    @Test
    public void test8()
    {
        byte bit = 0b1000000;
        System.out.println(bit);

        int number = 10_10;
        System.out.println(number+1);
    }
}
