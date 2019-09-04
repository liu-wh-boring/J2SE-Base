package chapter07.reflect;

import org.junit.Test;

public class T01_Reflect
{
    /**
     * 测试获取类的集中方式
     */
    @Test
    public void test01() throws ClassNotFoundException
    {
        //Object  getClass
        Class a = this.getClass();

        //类.class
        Class b = T01_Reflect.class;

        //Class.for
        Class c = Class.forName("chapter07.reflect.T01_Reflect");

        System.out.println(a == b);
        System.out.println(b == c);
    }
}
