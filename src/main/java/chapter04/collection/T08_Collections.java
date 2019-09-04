package chapter04.collection;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;



public class T08_Collections 
{
	/**
	 * 通过Collections生成一个不可修改的set
	 */
	@Test
	public void test()
	{
		Set<String> set = new TreeSet<String>();
		set.add("12");
		set.add("989");
		
		set = Collections.unmodifiableSet(set);
		set.forEach((i)->{System.out.println(i);});
		
		set.add("123");
	}
}
