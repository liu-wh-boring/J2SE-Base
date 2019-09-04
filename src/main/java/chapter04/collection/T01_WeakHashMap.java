package chapter04.collection;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，
 * 意思就是当 key 对象没有任何引用时，key/value 将会被回收。
 *
 */
public class T01_WeakHashMap {

	public static void main(String[] args) 
	{
		HashMap<Object,Integer> map = new HashMap<Object,Integer>();
	//	WeakHashMap<Object,Integer> map = new WeakHashMap<Object,Integer>();
		map.put(new Object(), 1);
		map.put(new Object(), 2);
		map.put(new Object(), 3);
		map.put(new Object(), 4);
		Object o = new Object();
		map.put(o, 55555);
		
		map.forEach((k,v)->{
			System.out.println(k+"="+v);
		});
		
		System.gc();
		System.out.println("------------------------------------------------");
		map.forEach((k,v)->{
			System.out.println(k+"="+v);
		});
	}

}
