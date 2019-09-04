package chapter08.jvm;

import java.io.IOException;
import java.io.InputStream;

public class T03_ClassLoader
{
    static class MyLoader extends ClassLoader
    {

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException
        {
            try
            {
                String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is=getClass().getResourceAsStream(fileName);
                if(is==null)
                {
                    return super.loadClass(name);
                }

                byte[]b = new byte[is.available()];
                is.read(b);
                return defineClass(name,b,0,b.length);

            }
            catch(IOException e)
            {
                throw new ClassNotFoundException(name);
            }
        }

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        MyLoader myLoader = new MyLoader();
        Object obj=myLoader.loadClass("chapter08.jvm.T03_ClassLoader").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof T03_ClassLoader);
        System.out.println(new Object().getClass());
        System.out.println(new Object().getClass() instanceof Object);

    }
}
