package chapter03.exception;

import org.junit.Test;

public class T01_Flow
{
    /**
     * 测试try catch的执行顺序
     */
    @Test
    public void test01()
    {
        try
        {
            System.out.println("try body begin");
            System.out.println(1/0);
            System.out.println("try body end");
        }
        catch (Exception e)
        {
            System.out.println("catch");
        }
        finally
        {
            System.out.println("finally");
        }
    }
}
