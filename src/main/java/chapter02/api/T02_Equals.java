package chapter02.api;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chapter02.api.po.Son;
import chapter02.api.po.Father;
import org.junit.Test;

public class T02_Equals 
{
	static class Person
	{
		private String name;

		@Override
		public int hashCode() 
		{
			return 1;//new Random().nextInt();
		}

		@Override
		public boolean equals(Object obj) 
		{
			return true;
		}
	}
	
	/**
	 * a==b 是比较两个对象的引用，只有当 a 和 b 指向的是堆中的同一个对象才会返回 true
	 */

	public void test1()
	{
		Person north = new Person();
		Person source = new Person();
		System.out.println(north==source);
	}
	
	/**
	 * 就是调用equals方法，如果方法没有重写，就是==
	 * 和hashcode 没有任务关系
	 */
	@Test
	public void test2()
	{
		Person north = new Person();
		Person source = new Person();
		System.out.println(north.equals(source));
	}
	
	/**
	 * hashcode和equals只有在基于哈希算法的的集合中才会一起使用
	 * 比较是否是同一对象：先比较哈希值，如果哈希值一样再比较equals
	 * 补充：“两个不同的键值对，哈希值相等”，这就是哈希冲突
	 */
	@Test
	public void test3()
	{
		Set<Person> set = new HashSet<Person>();
		
		set.add(new Person());
		
		//hash一样  equals = true
		System.out.println(set.add(new Person()));
	}

	@Test
	public void testForKind()
	{
		Father son = new Son();
		Father father = new Father();

		//类与类之间的关系
		//父类.class.isAssignableFrom(子类.class)
		System.out.println("----------------------------------isAssignableFrom-------------------------------");
		System.out.println(Son.class.isAssignableFrom(Father.class));
		System.out.println(Father.class.isAssignableFrom(Son.class));
		System.out.println(Number.class.isAssignableFrom(Double.class));
		Integer[] array = new Integer[1];
		System.out.println(array.getClass().isArray());


		//实例和类的关系
		/**
		 * 1.一个对象是本身类的一个对象
		 2.一个对象是本身类父类（父类的父类）和接口（接口的接口）的一个对象
		 3.所有对象都是Object
		 4.凡是null有关的都是false  null.instanceof(class)
		 */
		System.out.println("----------------------------instanceof-------------------------------");
		System.out.println(son instanceof Father);
		System.out.println(father instanceof Father);
		System.out.println(null instanceof Father);
		System.out.println(null instanceof Object);
		System.out.println(null instanceof List);

		//类和实例的关系
		/**
		 这个对象能不能被转化为这个类
		 1.一个对象是本身类的一个对象
		 2.一个对象能被转化为本身类所继承类（父类的父类等）和实现的接口（接口的父接口）强转
		 3.所有对象都能被Object的强转
		 4.凡是null有关的都是false   class.inInstance(null)
		 */
		System.out.println("------------------------isInstance----------------------------------------");
		System.out.println(Father.class.isInstance(son));
		System.out.println(Father.class.isInstance(father));


		System.out.println("------------------------------equals----------------------------------");
		//实例与实例之间的关系
		System.out.println(son.equals(father));
		System.out.println(son.equals(null));
	}
	
}
