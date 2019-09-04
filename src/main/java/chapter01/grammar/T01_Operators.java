package chapter01.grammar;



public class T01_Operators 
{
	/**
	 * &和&&都可以用作逻辑与的运算符，表示逻辑与（and），当运算符两边的表达式的结果都为true时，整个运算结果才为true，否则，只要有一方为false，则结果为false
	 */
	public void test01()
	{
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && false);
		System.out.println(true & true);
		System.out.println(true & false);
		System.out.println(false & false);
	}
	
	/**
	 * &&还具有短路的功能，即如果第一个表达式为false，则不再计算第二个表达式，例如，对于if(str != null && !str.equals(“”))表达式，
	 * 当str为null时，后面的表达式不会执行，所以不会出现NullPointerException如果将&&改为&，则会抛出NullPointerException异常。If(x==33 & ++y>0) 
	 * y会增长，If(x==33 && ++y>0)不会增长
	 */
	public void test02()
	{
		int i=0;
		int j=0;
		int k=0;
		System.out.println(false && (++i)>1 && (++j)>1 && (++k)>1);
		System.out.println(String.format("&&短路-i=%d,j=%d,k=%d", i,j,k));
		
		int r=0;
		int s=0;
		int t=0;
		System.out.println(false & (++r)>1 & (++s)>1 & (++t)>1 );
		System.out.println(String.format("&不短路-r=%d,s=%d,t=%d", r,s,t));
		
	}
	
	/**
	 * &还可以用作位运算符，当&操作符两边的表达式不是boolean类型时，&表示按位与操作，我们通常使用0x0f来与一个整数进行&运算，来获取该整数的最低4个bit位，例如，0x31 & 0x0f的结果为0x01。
	 */
	public void test03() 
	{
		int a = 9;
		int b= 5;
		System.out.println(String.format("第一个数据a=:%s",Integer.toBinaryString(a)));
		System.out.println(String.format("第一个数据b=:%s",Integer.toBinaryString(b)));

		System.out.println(String.format("按位与:%s",Integer.toBinaryString(a&b)));
		System.out.println(String.format("按位或:%s",Integer.toBinaryString(a|b)));
		System.out.println(String.format("按位非:%s",Integer.toBinaryString(~a)));
		//异或,都一样就是0,不一样就是1
		System.out.println(String.format("按位异或:%s",Integer.toBinaryString(a^b)));
		
		//左移;左移多少位等于乘以2的多少次方
		System.out.println(String.format("左移:%s",Integer.toBinaryString(a<<2)));
		//右移;右移多少位等于除以2的多少次方,然后向下取整
		//>>：带符号右移。正数右移高位补0，负数右移高位补1
		System.out.println(String.format("右移:%s",Integer.toBinaryString(a>>2)));
		
		//无符号右移。无论是正数还是负数，高位通通补0
		//对于正数而言，>>和>>>没区别
		
		//在计算机中负数采用二进制的补码表示，10进制转为二进制得到的是源码，将源码按位取反得到的是反码，反码加1得到补码
		//二进制的最高位是符号位，0表示正，1表示负。
		//>>>与>>唯一的不同是它无论原来的最左边是什么数，统统都用0填充。
		//——比如，byte是8位的，-1表示为byte型是11111111(补码表示法）
		//b>>>4就是无符号右移4位，即00001111，这样结果就是15
		System.out.println(String.format(">>>原始数据:%s",Integer.toBinaryString(-1)));
		System.out.println(String.format(">>>之后的数据:%s",Integer.toBinaryString(-1>>1)));
		System.out.println(String.format(">>>之后的数据:%s",-1>>1));
	}
}
