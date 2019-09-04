package chapter05.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class T01_Generics
{

	//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
	//在实例化泛型类时，必须指定T的具体类型
	/**
	 * 1.泛型类的写法
	 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
	 * 在实例化泛型类时，必须指定T的具体类型
	 */
	class demo1 <T>
	{
		private T name;
	}
	
	
	/**
	 * 2.泛型接口的写法
	 */
	interface GenericsInterface <T,K>
	{
		T print();
		K print(K k);
	}
	
	
	/**
	 * 3。泛型接口的继承
	 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
	 * 即：class FruitGenerator<T> implements Generator<T>
	 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
	 * 也可以添加多个泛型参数进去
	 */
	public class GenericsFruit<K,T> implements GenericsInterface<T,K> 
	{
		private K a;
		private T b;

		public GenericsFruit(K a, T b) 
		{
			this.a = a;
			this.b = b;
		}

		@Override
		public T print() 
		{
			return null;
		}

		@Override
		public K print(K k) 
		{
			return null;
		}

	}
	
	/**
	 * 4.泛型接口的继承,传入实参
	 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口Generator<T>
	 * 但是我们可以为T传入无数个实参，形成无数种类型的Generator接口。
	 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
	 * 即：Generator<T>，public T print();中的的T都要替换成传入的String类型。
	 */
	public class GenericsFruit2 implements GenericsInterface<String,Integer> 
	{

		@Override
		public String print() 
		{
			return null;
		}

		@Override
		public Integer print(Integer k) 
		{
			return null;
		}
	}
	
	/**
	 * 5.泛型的擦除
	 * 在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。在编译过程中，
	 * 正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
	 * 也就是说，泛型信息不会进入到运行时阶段
	 */
	@Test
	public  void test01()
	{
		List<String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());
	}
	
	/**
	 * 6.泛型类的实例化
	 *泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
	 *传入的实参类型需与泛型的类型参数类型相同.
	 */
	public  void test02()
	{
		//编译报错
		//T01_GenericsClass<String,int> t = new T01_GenericsClass();
		
		//编译报错
		//T01_GenericsClass<String,Integer> t = new T01_GenericsClass<>("name",2.2);
	}
	
	/**
	 * 7.instanceof现在
	 * 不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
	 * if(ex_num instanceof Generic<Number>){ }
	 */
	public  void test03()
	{
		GenericsFruit<String,Integer> t = new GenericsFruit<String,Integer>("name",2);
//		if( t instanceof T01_GenericsClass<String,Integer>)
//		{
//			
//		}
		
		//只能这样
		if( t instanceof GenericsFruit)
		{
			
		}
	}
	
	/**
	 * 8.泛型的统配
	 * List<Ingeter>与List<Number>实际上是相同的一种基本类型。那么问题来了，在使用List<Number>作为形参的方法中，
	 * 能否使用List<Ingeter>的实例传入呢？在逻辑上类似于List<Number>和List<Ingeter>是否可以看成具有父子关系的泛型类型呢
	 */
	private void setList(List<Number> list)
	{
		System.out.println(list);
	}
	
	/**
	 * 通过提示信息我们可以看到<Ingeter>不是List<Number>的子类,不能混合使用
	 */
	public void test04()
	{
		List<Number> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(1,2,3);
		
		setList(list1);
		//这个方法编译器会为我们报错
		//setList(list2);
	}
	
	/**
	 * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参
	 * 此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型
	 */
	private void setList2(List<?> list)
	{
		System.out.println(list);
	}
	
	@Test
	public void test05()
	{
		List<Number> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(1,2,3);
		
		setList2(list1);
		setList2(list2);
	}
	
	/**
	 * 9。泛型的方法
	 * 1)泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型 
	 * 2)public 与 返回值中间<T,K>非常重要，可以理解为声明此方法为泛型方法
	 * 3)只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法
	 * 4)<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
	 * 5)如果可以使用泛型方法满足要求,则尽量不要使用泛型类
	 */
	public <T,K> T getSomething(K k,T t)
	{
		if( k.getClass() == Integer.class)
		{
			return t;
		}
		return null;
	}
	
	/**
	 * 如果是一个泛型的类，为了测试，类的泛型去掉
	 * 这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
	 * public S getS()
	   {
		  return null;
	   }
	 */
	
	
	/**
     * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
     * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
	public E setKey(E key)
	{
       return null;
    } 
	*/

	@Test
	public void test06()
	{
		T01_Generics test = new T01_Generics();
		System.out.println(test.getSomething(1, 2));
	}
	
	/**
	 * 10.泛型和可变参数
	 */
	public <T> void printMsg( T... args)
	{
		for(T t : args)
	    {
	    	System.out.println(t);
	    }
	}
	
	@Test
	public void test07()
	{
		this.printMsg(12,34,56,78);
	}
	
	/**
	 * 11.静态方法和泛型
	 * 静态方法无法访问类上定义的泛型
	 */
	static class demo<S>
	{
//		static S  doSome()
//		{
//			return null;
//		}
		
		S doSome2()
		{
			return null;
		}
	}
	
	/**
	 * 如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上
	 */
	static <S> void doSome(S s)
	{
		System.out.println(s);
	}
	
	@Test
	public void test08()
	{
		T01_Generics.doSome(78968);;
	}
	
	/**
	 * 12. 泛型方法的上界
	 */
	class Animal{}
	class Dog extends Animal{void print(){};};
	class ChineseDog extends Dog{};
	class SmallChineseDog extends ChineseDog{};
	
	/**
	 * 确定T类型的上界,该类只能是继承Dog的类
	 * 目前没有发现泛型方法下界的写法
	 */
	private <T extends Dog> void printS(T t)
	{
		t.print();
		System.out.println(t.toString());
	}
	
	@Test
	public void test09()
	{
		Animal animal = new Animal();
		Dog dog = new Dog();
		ChineseDog cd = new ChineseDog();
		SmallChineseDog scd = new SmallChineseDog();
		
		T01_Generics test = new T01_Generics();
		//此处编译报错
		//test.printS(animal);
		test.printS(dog);
		test.printS(cd);
		test.printS(scd);
	}
	
	/**
	 * 13.泛型类的上界
	 * 目前没有发现泛型类下界的写法
	 */
	class BigDog<E extends Dog>
	{
		
	}
	
	@Test
	public void test10()
	{
		new BigDog<ChineseDog>();
	
		//此处编译报错
		//new BigDog<Animal>();
	}
	
	/**
	 * 14.通配符的上界
	 * ist<? extends E>list=new LinkedList<F>();      //带上边界  F是B中任意值
	 * 
	 * 如果是? super Dog 可以设置Dog的子类
	 * 如果是? extends Dog 不可以添加任何元素
	 */
	@Test
	public void test11()
	{
		ArrayList<? super Dog> list = new ArrayList<>();
		list.add(new Dog());
		list.add(new ChineseDog());
	}
	
}

