package chapter01.grammar;


public class T02_Loop 
{
	/**
	 * 2、Java有没有goto?
	 */
	/**
	 * java中的保留字，现在没有在java中使用;
	 * 保留字的意思就是不排除以后会启用,变成关键字;
	 * 没有goto语句，也没有任何使用goto关键字的地方;
	 * java中类似于goto功能的标签使用
	 * 
	 * goto 关键字很早就在程序设计语言中出现。事实上，goto 是汇编语言的程序控制结构的始祖：“若条件 A，
		则跳到这里；否则跳到那里”。若阅读由几乎所有编译器生成的汇编代码，就会发现程序控制里包含了许多
		跳转。然而，goto 是在源码的级别跳转的，所以招致了不好的声誉。若程序总是从一个地方跳到另一个地
		方，还有什么办法能识别代码的流程呢？随着 Edsger Dijkstra 著名的“Goto 有害”论的问世，goto 便从此
		失宠。
		事实上，真正的问题并不在于使用 goto ，而在于 goto 的滥用。而且在一些少见的情况下，goto 是组织控制
		流程的最佳手段。
		尽管 goto 仍是 Java 的一个保留字，但并未在语言中得到正式使用；Java 没有 goto 。然而，在 break 和
		continue 这两个关键字的身上，我们仍然能看出一些 goto 的影子。它并不属于一次跳转，而是中断循环语
		句的一种方法。之所以把它们纳入 goto 问题中一起讨论，是由于它们使用了相同的机制：标签。
		“标签”是后面跟一个冒号的标识符，就象下面这样：
		label1:
		对 Java 来说，唯一用到标签的地方是在循环语句之前。进一步说，它实际需要紧靠在循环语句的前方——在
		标签和循环之间置入任何语句都是不明智的。而在循环之前设置标签的唯一理由是：我们希望在其中嵌套另
		一个循环或者一个开关。这是由于 break 和 continue 关键字通常只中断当前循环，但若随同标签使用，它们
		就会中断到存在标签的地方
	 */
	/**
	 * 使用标签形式
	 */
	public void test02()
	{	
		outter:for(int i = 0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.println(String.format("i=%d,j=%d",i,j));
				if(j==5)
				{
					break outter;
				}
			}
			System.out.println("+++++++++++++++");
		}
		System.out.println("----------------------");
	}
	
	/**
	 * 如果不使用标签,那么只能立flag
	 */
	public void test02_01()
	{	
		boolean flag = true;
		for(int i = 0;i<10 && flag;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.println(String.format("i=%d,j=%d",i,j));
				if(j==5)
				{
					flag=false;
					break ;
				}
			}
			if(flag)
			{
				System.out.println("+++++++++++++++");
			}
		}
		System.out.println("----------------------");
	}
}
