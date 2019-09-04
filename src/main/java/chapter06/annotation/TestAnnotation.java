package chapter06.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestAnnotation 
{
	/**
	 * 1.Java SE5内置了三种标准注解
	 */
	/**
	 * 1.1
	 * @Deprecated，使用了注解为它的元素编译器将发出警告，因为注解@Deprecated是不赞成使用的代码，被弃用的代码
	 */
	@Deprecated
	public void test01()
	{
		
	}

	/**
	 * 1.2
	 * @SuppressWarnings 关闭不当编译器警告信息
	 * 他的值是一个字符串数组,可变长度的类型 相当于。。。
	 */
	public void test02()
	{
		List<?> list = new ArrayList<>();
		@SuppressWarnings({ "unused", "unchecked" })
		List<String> nList = (List<String>)list;
	}
	
	/**
	 * 1.3
	 * 也可以单个元素
	 * 
	 * deprecation  -- 使用了不赞成使用的类或方法时的警告
unchecked    -- 执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
fallthrough  -- 当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。
path         -- 在类路径、源文件路径等中有不存在的路径时的警告。
serial       -- 当在可序列化的类上缺少 serialVersionUID 定义时的警告。
finally      -- 任何 finally 子句不能正常完成时的警告。
all          -- 关于以上所有情况的警告。
	 */
	@SuppressWarnings("unchecked")
	public void test03()
	{
		List<?> list = new ArrayList<>();
		List<String> nList = (List<String>)list;
		System.out.println(nList);
	}
	
	/**
	 * 1.4
	 * Override:重写方法
	 */
	@Override
	public String toString()
	{
		return null;
	}
	
	/**
	 * 2.Java还提供了4中注解，专门负责新注解的创建
	 */
	/**
	 * 2.1
	 * @Target:表示该注解可以用于什么地方，可能的ElementType参数有：
	 *	CONSTRUCTOR：构造器的声明
		FIELD：域声明（包括enum实例）
		LOCAL_VARIABLE：局部变量声明
		METHOD：方法声明
		PACKAGE：包声明
		PARAMETER：参数声明
		TYPE：类、接口（包括注解类型）或enum声明
	 */
	
	/**
	 * 
	 * 结构体
	 */
	@Target(ElementType.CONSTRUCTOR)
	@interface Mark_CONSTRUCTOR{}
	
	@Target(ElementType.FIELD)
	@interface Mark_FIELD{};
	
	@Target(ElementType.LOCAL_VARIABLE)
	@interface Mark_LOCAL_VARIABLE{}
	
	@Target(ElementType.METHOD)
	@interface Mark_METHOD{}
	
	@Target(ElementType.PACKAGE)
	@interface Mark_PACKAGE{}
	
	@Target(ElementType.PARAMETER)
	@interface Mark_PARAMETER{}
	
	static class Test04
	{
		@Mark_FIELD//修饰静态变量
		private final static int max=100;
		
		@Mark_FIELD//修饰成员变量
		private int min=10;
		
		@Mark_CONSTRUCTOR
		Test04()
		{
			@Mark_LOCAL_VARIABLE//修改局部变量
			@SuppressWarnings("unused")
			int a=10;
		}
		
		@Mark_METHOD //修饰方法
		private void add(@Mark_PARAMETER int a,@Mark_PARAMETER int b)
		{
			
		}
	}
	@Target(ElementType.TYPE)
	@interface Mark_TYPE{}
	
	@Mark_TYPE //注解类
	class test05{}
	
	@Mark_TYPE //注解接口
	interface test06{}
	
	@Mark_TYPE //注解注解
	@interface test07{}
	
	@Mark_TYPE //注解枚举
	enum test08{} 
	
	/**
	 *  2.2
		@Retention:表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
		SOURCE：注解将被编译器丢弃
		CLASS：注解在class文件中可用，但会被VM丢弃
		RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息。
	 *
	 */
	@Retention(RetentionPolicy.SOURCE) //只存活在源码期间
	@interface Mark_SOURCE{}
	
	@Retention(RetentionPolicy.CLASS) //存活到编译器
	@interface Mark_CLASS{}
	
	@Retention(RetentionPolicy.RUNTIME) //存活到运行期
	@interface Mark_RUNTIME{};
	
	/**
	 * 2.3
	 * @Document 将注解包含在Javadoc中
	 */
	
	/**
	 * 2.4
	 *@Inherited允许子类继承父类中的注解
	 */
	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@interface Mark_INHERITED{}
	
	@Mark_INHERITED
	interface P{}
	
	class C implements P{}
	
	@Test
	public void test09()
	{
		System.out.println(C.class.isAnnotationPresent(Mark_INHERITED.class));
	}
	
	/**
	 * 3 自定义注解
	 */
	@Target({ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	@interface FiledAnnotation
	{
		String name();//类似接口中属性的写法
		String color() default "red"; //定义缺省值
	}
	
	class Demo
	{
		@FiledAnnotation(name="zhangsan")
		private int e;
		
		@FiledAnnotation(name="lisi",color="yellow")
		private int d;
	}
	
	@Test
	public void test10()
	{
		Field[] f = Demo.class.getDeclaredFields();
		for(Field i :f)
		{
			FiledAnnotation a = i.getAnnotation(FiledAnnotation.class);
			System.out.println(i.getName());
			System.out.println(a.name());
			System.out.println(a.color());
			System.out.println("------------------------------------------------");
		}
		
	}
	
}
