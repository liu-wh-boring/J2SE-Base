package chapter08.jvm;

public class T01_Order
{
    /**
     * 常量入栈
     */
    /**
     * 1。1常量推送到栈顶
     * 该系列命令主要负责把简单的数值类型送到栈顶。该系列命令不带参数。注意只把简单的数值类型送到栈顶时，才使用如下的命令。
     * 比如对应int型才该方式只能把-1,0,1,2,3,4,5（分别采用iconst_m1,iconst_0, iconst_1, iconst_2, iconst_3, iconst_4, iconst_5）
     * 送到栈顶。对于int型，其他的数值请使用push系列命令（比如bipush）。
     * const:将有限的数值推送至栈顶
     */
    public void testConst()
    {
        //int num = 15;0x01 aconst_null 将null推送至栈顶
        String str = null;

        //0x02 iconst_m1    将int型-1推送至栈顶
        int int_1 = -1;

        //0x03 iconst_0    将int型0推送至栈顶
        int int0 = 0;
        boolean boolean_ = false;//false=0

        //0x04 iconst_1    将int型1推送至栈顶
        int int1 = 1;

        //0x05 iconst_2    将int型2推送至栈顶
        int int2 = 2;

        //0x06 iconst_3    将int型3推送至栈顶
        int int3 = 3;

        //0x07 iconst_4    将int型4推送至栈顶
        int int4 = 4;

        //0x08 iconst_5    将int型5推送至栈顶
        int int5 = 5;

        //0x09 lconst_0    将long型0推送至栈顶
        long l0 = 0;

        //0x0a lconst_1    将long型1推送至栈顶
        long l1 = 1;

        //0x0b fconst_0    将float型0推送至栈顶
        float f0 = 0;

        //0x0c fconst_1    将float型1推送至栈顶
        float f1 = 1;

        //0x0d fconst_2    将float型2推送至栈顶
        float f2 = 2;

        //0x0e dconst_0    将double型0推送至栈顶
        double d0 = 0;

        //0x0f dconst_1    将double型1推送至栈顶
        double d1 = 1;
    }

    /**
     * 1.2常量推送到栈顶
     * 该系列命令负责把一个整形数字（长度比较小）送到到栈顶。该系列命令有一个参数，用于指定要送到栈顶的数字。
     * 注意该系列命令只能操作一定范围内的整形数值，超出该范围的使用将使用ldc命令系列。
     * 将const无法处理的常量推送至栈顶 带参数的,参数是值
     */
    public void testPush()
    {
        //0x10 bipush    将单字节的常量值(-128~127)推送至栈顶 ,byte范围内,即使定义成int
        char char_ = '1';
        int bipush1 = -128;
        int bipush2 = 127;

        //0x11 sipush    将一个短整型常量值(-32768~32767)推送至栈顶 short
        int sipush1 = 9987;
        short sipush2 = 8767;
    }

    /**
     * 1.3常量推送到栈顶
     * 该系列命令负责把数值常量或String常量值从常量池中推送至栈顶。该命令后面需要给一个表示常量在常量池中位置(编号)的参数，
     * 哪些常量是放在常量池呢？比如：final static int id=32768;final static float double=6.5。
     * 对于const系列命令和push系列命令操作范围之外的数值类型常量，都放在常量池中.
     * 另外，所有不是通过new创建的String都是放在常量池中的。
     */
    public void TestLDC()
    {
        //0x12 ldc    将int, float或String型常量值从常量池中推送至栈顶
        int int_ = 327678989;
        float float_ = 3f;
        String string_ = "OOCCXX";

        //不知道这个是怎么用的
        //0x13 ldc_w    将int, float或String型常量值从常量池中推送至栈顶（宽索引）

        //0x14 ldc2_w    将long或double型常量值从常量池中推送至栈顶（宽索引）
        long long_ = 10;
        double double_ = 10.9;
    }

    /**
     * 2变量(局部变量表)入栈
     */
    /**
     * 2.1局部变量表推送到栈顶
     * loadA
     * 该系列命令负责把本地变量的送到栈顶。这里的本地变量不仅可以是数值类型，还可以是引用类型。
     * 对于前四个本地变量可以采用iload_0,iload_1,iload_2,iload_3(它们分别表示第0,1,2,3个整形变量)这种不到参数的简化命令形式。
     * 对于第4以上的本地变量将使用iload命令这种形式，在它后面给一参数，以表示是对第几个(从0开始)本类型的本地变量进行操作。
     * 对本地变量所进行的编号，是对所有类型的本地变量进行的（并不按照类型分类）。
     * 对于非静态函数，第一变量是this,即其对于的操作是aload_0.还有函数传入参数也算本地变量，在进行编号时，它是先于函数体的本地变量的。
     */
    public static void testLoadA()
    {
        int int_0=0;
        int int_1=11111;
        int int_2=22222;
        int int_3=33333;
        //0x15 iload    将指定的int型本地变量推送至栈顶
        int int_4 = 44444;
        int int_load = int_4; //此处将int_4推送到栈顶

        //0x1a iload_0    将第一个int型本地变量推送至栈顶
        int_load = int_0;

        //0x1b iload_1    将第二个int型本地变量推送至栈顶
        int_load = int_1;

        //0x1c iload_2    将第三个int型本地变量推送至栈顶
        int_load = int_2;

        //0x1d iload_3    将第四个int型本地变量推送至栈顶
        int_load = int_3;

        //0x16 lload    将指定的long型本地变量推送至栈顶
        //0x17 fload    将指定的float型本地变量推送至栈顶
        //0x18 dload    将指定的double型本地变量推送至栈顶
        //0x19 aload    将指定的引用类型本地变量推送至栈顶

        //0x1e lload_0    将第一个long型本地变量推送至栈顶
        //0x1f lload_1    将第二个long型本地变量推送至栈顶
        //0x20 lload_2    将第三个long型本地变量推送至栈顶
        //0x21 lload_3    将第四个long型本地变量推送至栈顶

        //0x22 fload_0    将第一个float型本地变量推送至栈顶
        //0x23 fload_1    将第二个float型本地变量推送至栈顶
        //0x24 fload_2    将第三个float型本地变量推送至栈顶
        //0x25 fload_3    将第四个float型本地变量推送至栈顶

        //0x26 dload_0    将第一个double型本地变量推送至栈顶
        //0x27 dload_1    将第二个double型本地变量推送至栈顶
        //0x28 dload_2    将第三个double型本地变量推送至栈顶
        //0x29 dload_3    将第四个double型本地变量推送至栈顶

        //0x2a aload_0    将第一个引用类型本地变量推送至栈顶
        //0x2b aload_1    将第二个引用类型本地变量推送至栈顶
        //0x2c aload_2    将第三个引用类型本地变量推送至栈顶
        //0x2d aload_3    将第四个引用类型本地变量推送至栈顶
    }

    /**
     * 2.2局部变量表中数组的某项数据推送栈顶
     * load系列B
     * 该系列命令负责把数组的某项送到栈顶。该命令根据栈里内容来确定对哪个数组的哪项进行操作,所以在此之前需要入栈两个信息
     */
    public void testLoadB()
    {
        //0x2e iaload    将int型数组指定索引的值推送至栈顶
        int[] a = new int[5];
        int b = a[4];
        /**
         0: iconst_5	//将int常量5入栈
         1: newarray       int //生成数组
         3: astore_1	//将栈顶引用类型存在到局部变量表中第二个位置
         4: aload_1		//将局部变量表中第二个位置的引用类型入栈--------指定了是哪个数组
         5: iconst_4	//将int常量4入栈 ------指定了数组位置
         6: iaload		//将int型数组指定索引的值推送至栈顶
         7: istore_2	//将栈顶存储到局部变量表第三个位置
         8: return
         */

        //0x2f laload    将long型数组指定索引的值推送至栈顶
        //0x30 faload    将float型数组指定索引的值推送至栈顶
        //0x31 daload    将double型数组指定索引的值推送至栈顶
        //0x32 aaload    将引用型数组指定索引的值推送至栈顶
        //0x33 baload    将boolean或byte型数组指定索引的值推送至栈顶
        //0x34 caload    将char型数组指定索引的值推送至栈顶
        //0x35 saload    将short型数组指定索引的值推送至栈顶
    }

    /**
     * 3赋值：栈顶的值存入本地变量表
     */
    /**
     * 3.1栈顶的值存入本地变量表
     * 该系列命令负责把栈顶的值存入本地变量。这里的本地变量不仅可以是数值类型，还可以是引用类型。
     * 如果是把栈顶的值存入到前四个本地变量的话，采用的是istore_0,istore_1，istore_2，istore_3(它们分别表示第0,1,2,3个本地整形变量)这种不到参数的简化命令形式。
     * 如果是把栈顶的值存入到第四个以上本地变量的话，将使用istore命令这种形式，在它后面给一参数，以表示是把栈顶的值存入到第几个(从0开始)本地变量中。
     * 对本地变量所进行的编号，是对所有类型的本地变量进行的（并不按照类型分类）。
     * 对于非静态函数，第一变量是this,它是只读的.
     * 还有函数传入参数也算本地变量，在进行编号时，它是先于函数体的本地变量的。
     */
    public static void testStoreA()
    {
        //0x3b istore_0    将栈顶int型数值存入第一个本地变量
        int int_store_1 = 1;
        //0x3c istore_1    将栈顶int型数值存入第二个本地变量
        int int_store_2 = 2;
        //0x3d istore_2    将栈顶int型数值存入第三个本地变量
        int int_store_3 = 3;
        //0x3e istore_3    将栈顶int型数值存入第四个本地变量
        int int_store_4 = 4;
        //0x36 istore    将栈顶int型数值存入指定本地变量
        int int_store_5 = 5;

        //0x37 lstore    将栈顶long型数值存入指定本地变量
        //0x38 fstore    将栈顶float型数值存入指定本地变量
        //0x39 dstore    将栈顶double型数值存入指定本地变量
        //0x3a astore    将栈顶引用型数值存入指定本地变量

        //0x3f lstore_0    将栈顶long型数值存入第一个本地变量
        //0x40 lstore_1    将栈顶long型数值存入第二个本地变量
        //0x41 lstore_2    将栈顶long型数值存入第三个本地变量
        //0x42 lstore_3    将栈顶long型数值存入第四个本地变量

        //0x43 fstore_0    将栈顶float型数值存入第一个本地变量
        //0x44 fstore_1    将栈顶float型数值存入第二个本地变量
        //0x45 fstore_2    将栈顶float型数值存入第三个本地变量
        //0x46 fstore_3    将栈顶float型数值存入第四个本地变量

        //0x47 dstore_0    将栈顶double型数值存入第一个本地变量
        //0x48 dstore_1    将栈顶double型数值存入第二个本地变量
        //0x49 dstore_2    将栈顶double型数值存入第三个本地变量
        //0x4a dstore_3    将栈顶double型数值存入第四个本地变量

        //0x4b astore_0    将栈顶引用型数值存入第一个本地变量
        //0x4c astore_1    将栈顶引用型数值存入第二个本地变量
        //0x4d astore_2    将栈顶引用型数值存入第三个本地变量
        //0x4e astore_3    将栈顶引用型数值存入第四个本地变量
    }

    /**
     * 3.2栈顶数据存储本地表里表中的数组的某项中
     * 该系列命令负责把栈顶项的值存到数组里。该命令根据栈里内容来确定对哪个数组的哪项进行操作
     */
    public void testStoreB()
    {
        //0x4f iastore    将栈顶int型数值存入指定数组的指定索引位置
        int[] a = new int[100];
        a[7] = 64;
        int b = a[6];
        /**
         0: bipush        100  //将常量100推入栈顶
         2: newarray       int	//栈顶生成数组
         4: astore_1		//将栈顶引用类型放到本地变量表第二个位置
         5: aload_1			//将本地变量表第二个位置的引用类型入栈 ------指定了是哪个数组
         6: bipush        7 //将常量7入栈----------------------指定了位置的索引
         8: bipush        64//将常量64入栈---------------------指定要操作的值
         10: iastore //将栈顶指定数组 指定索引 指定值存储到本地变量表
         11: return
         *
         */
        //0x50 lastore    将栈顶long型数值存入指定数组的指定索引位置
        //0x51 fastore    将栈顶float型数值存入指定数组的指定索引位置
        //0x52 dastore    将栈顶double型数值存入指定数组的指定索引位置
        //0x53 aastore    将栈顶引用型数值存入指定数组的指定索引位置
        //0x54 bastore    将栈顶boolean或byte型数值存入指定数组的指定索引位置
        //0x55 castore    将栈顶char型数值存入指定数组的指定索引位置
        //0x56 sastore    将栈顶short型数值存入指定数组的指定索引位置
    }

    /**
     * 4复制和弹栈
     * 该系列命令似乎只是简单对栈顶进行操作
     */
    public void testPop()
    {
        int[] int_array = new int[] {1,2,3,4};

        //0x57 pop     将栈顶数值弹出 (数值不能是long或double类型的)
        //0x58 pop2    将栈顶的一个（long或double类型的)或两个数值弹出（其它）
        //0x59 dup     复制栈顶数值并将复制值压入栈顶
        //0x5a dup_x1    复制栈顶数值并将两个复制值压入栈顶
        //0x5b dup_x2    复制栈顶数值并将三个（或两个）复制值压入栈顶
        //0x5c dup2    复制栈顶一个（long或double类型的)或两个（其它）数值并将复制值压入栈顶
        //0x5d dup2_x1    复制栈顶数值(long或double类型的)并将两个复制值压入栈顶
        //0x5e dup2_x2    复制栈顶数值(long或double类型的)并将三个（或两个）复制值压入栈顶
    }

    /**
     * 5计算
     * 该系列命令用于对栈顶元素行数学操作，和对数值进行移位操作。移位操作的操作数和要移位的数都是从栈里取得
     */
    public void testCalc()
    {
        //0x5f swap    将栈最顶端的两个数值互换(数值不能是long或double类型的)

        //0x60 iadd    将栈顶两int型数值相加并将结果压入栈顶
        //0x61 ladd    将栈顶两long型数值相加并将结果压入栈顶
        //0x62 fadd    将栈顶两float型数值相加并将结果压入栈顶
        //0x63 dadd    将栈顶两double型数值相加并将结果压入栈顶
        int a=1+2;
        /**
         * iconst_3 //编译器直接计算出来
         * istore_1
         */
        int a1=1;
        int a2=0;
        int add = a1+a2;


        //0x64 isub    将栈顶两int型数值相减并将结果压入栈顶
        //0x65 lsub    将栈顶两long型数值相减并将结果压入栈顶
        //0x66 fsub    将栈顶两float型数值相减并将结果压入栈顶
        //0x67 dsub    将栈顶两double型数值相减并将结果压入栈顶

        //0x68 imul    将栈顶两int型数值相乘并将结果压入栈顶
        //0x69 lmul    将栈顶两long型数值相乘并将结果压入栈顶
        //0x6a fmul    将栈顶两float型数值相乘并将结果压入栈顶
        //0x6b dmul    将栈顶两double型数值相乘并将结果压入栈顶

        //0x6c idiv    将栈顶两int型数值相除并将结果压入栈顶
        //0x6d ldiv    将栈顶两long型数值相除并将结果压入栈顶
        //0x6e fdiv    将栈顶两float型数值相除并将结果压入栈顶
        //0x6f ddiv    将栈顶两double型数值相除并将结果压入栈顶

        //0x70 irem    将栈顶两int型数值作取模运算并将结果压入栈顶
        //0x71 lrem    将栈顶两long型数值作取模运算并将结果压入栈顶
        //0x72 frem    将栈顶两float型数值作取模运算并将结果压入栈顶
        //0x73 drem    将栈顶两double型数值作取模运算并将结果压入栈顶

        //0x74 ineg    将栈顶int型数值取负并将结果压入栈顶
        //0x75 lneg    将栈顶long型数值取负并将结果压入栈顶
        //0x76 fneg    将栈顶float型数值取负并将结果压入栈顶
        //0x77 dneg    将栈顶double型数值取负并将结果压入栈顶

        //0x78 ishl    将int型数值左移位指定位数并将结果压入栈顶
        //0x79 lshl    将long型数值左移位指定位数并将结果压入栈顶

        //0x7a ishr    将int型数值右（符号）移位指定位数并将结果压入栈顶
        //0x7b lshr    将long型数值右（符号）移位指定位数并将结果压入栈顶

        //0x7c iushr    将int型数值右（无符号）移位指定位数并将结果压入栈顶
        //0x7d lushr    将long型数值右（无符号）移位指定位数并将结果压入栈顶

        //0x7e iand    将栈顶两int型数值作“按位与”并将结果压入栈顶
        //0x7f land    将栈顶两long型数值作“按位与”并将结果压入栈顶

        //0x80 ior     将栈顶两int型数值作“按位或”并将结果压入栈顶
        //0x81 lor     将栈顶两long型数值作“按位或”并将结果压入栈顶

        //0x82 ixor    将栈顶两int型数值作“按位异或”并将结果压入栈顶
        //0x83 lxor    将栈顶两long型数值作“按位异或”并将结果压入栈顶

        //0x84 iinc    将指定int型变量增加指定值（i++, i--, i+=2 ,i-=2）
        //该指令用于对本地(局部)变量进行自增减操作。该指令第一参数为本地变量的编号，第二个参数为自增减的数量
        a1++;
        a1--;
        a1+=2;
        a1-=2;
        a1*=2; //等效于a1 = a1*2
    }

    /**
     * 6 类型转换
     * 该系列指令负责对栈顶数值类型进行类型转化，并把结果压入栈顶
     */
    public void testTransfer(int a,float b,long c, double d)
    {
        //0x85 i2l     将栈顶int型数值强制转换成long型数值并将结果压入栈顶
        //0x86 i2f     将栈顶int型数值强制转换成float型数值并将结果压入栈顶
        //0x87 i2d     将栈顶int型数值强制转换成double型数值并将结果压入栈顶
        double result = a+b;
        int i = (int)result;
        //0x88 l2i     将栈顶long型数值强制转换成int型数值并将结果压入栈顶
        //0x89 l2f     将栈顶long型数值强制转换成float型数值并将结果压入栈顶
        //0x8a l2d     将栈顶long型数值强制转换成double型数值并将结果压入栈顶

        //0x8b f2i     将栈顶float型数值强制转换成int型数值并将结果压入栈顶
        //0x8c f2l     将栈顶float型数值强制转换成long型数值并将结果压入栈顶
        //0x8d f2d     将栈顶float型数值强制转换成double型数值并将结果压入栈顶

        //0x8e d2i     将栈顶double型数值强制转换成int型数值并将结果压入栈顶
        //0x8f d2l     将栈顶double型数值强制转换成long型数值并将结果压入栈顶
        //0x90 d2f     将栈顶double型数值强制转换成float型数值并将结果压入栈顶

        //0x91 i2b     将栈顶int型数值强制转换成byte型数值并将结果压入栈顶
        byte bb = (byte)i;
        //0x92 i2c     将栈顶int型数值强制转换成char型数值并将结果压入栈顶
        char cc = (char)i;
        //0x93 i2s     将栈顶int型数值强制转换成short型数值并将结果压入栈顶
        short ss = (short)i;
    }

    /**
     * 7 比较指令跳转指令
     */
    /**
     * 7.1比较指令
     * 针对long fload double类型,无跳转
     * 比较结果true 1 ;false 0
     */
    public void testCompareAndGoA()
    {
        //0x94 lcmp     比较栈顶两long型数值大小，并将结果（1，0，-1）压入栈顶
        long a=987655432L;
        long b=87655435680L;
        boolean result = a>b ;
        /**
         *
         0: ldc2_w        #95 //常量入栈                // long 987655432l
         3: lstore_1		  //栈顶到本地表
         4: ldc2_w        #97 //常量入栈                // long 87655435680l
         7: lstore_3		  //栈顶到本地表
         8: lload_1			  //本地表第二个位置入栈
         9: lload_3			  //本地表第四个位置入栈
         10: lcmp			  //比较栈顶两long型数值大小，并将结果（1，0，-1）压入栈顶
         11: ifle          18  //栈顶int型数值小于等于0时跳转命令行18,if false语义
         14: iconst_1		  //常量1入栈
         15: goto          19  //跳转命令行19
         18: iconst_0		  //常量0入栈
         19: istore        5	  //栈顶到本地表
         21: return
         */
        //0x95 fcmpl    比较栈顶两float型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将-1压入栈顶
        //0x96 fcmpg    比较栈顶两float型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将1压入栈顶
        //0x97 dcmpl    比较栈顶两double型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将-1压入栈顶
        //0x98 dcmpg    比较栈顶两double型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为NaN时，将1压入栈顶
    }

    /**
     * 7.2该系列指令用于对栈顶int型元素进行比较，根据结果进行跳转。
     * 有条件跳转
     * 第一个参数为要跳转到的代码的地址（这里的地址是指其指令在函数内是第几个指令）。
     * 注意对于boolean型，其实是把它当做int型来处理的。另外对于引用比较使用的时，其实是对存储的对象的地址进行比较。
     */
    public void testCompareAndGoB()
    {
        int a=0;
        if( a != 0)
        {
            int c=0;
            return;
        }
        //0x99 ifeq    当栈顶int型数值等于0时跳转
        //0x9a ifne    当栈顶int型数值不等于0时跳转 				a == 0
        //0x9b iflt    当栈顶int型数值小于0时跳转				a >= 0
        //0x9c ifge    当栈顶int型数值大于等于0时跳转				a < 0
        //0x9d ifgt    当栈顶int型数值大于0时跳转				a <= 0
        //0x9e ifle    当栈顶int型数值小于等于0时跳转				a > 0 	a != 0
    }

    /**
     * 7.3该系列指令用于对比较栈顶两int型数值大小，根据结果进行跳转
     * 有条件
     */
    public void testCompareAndGoC()
    {

        //0x9f if_icmpeq    比较栈顶两int型数值大小，当结果等于0时跳转
        int a=1;
        int b=0;
        if( a == b )
        {
            int c=0;
            return;
        }
        return;
        //0xa0 if_icmpne    比较栈顶两int型数值大小，当结果不等于0时跳转
        //0xa1 if_icmplt    比较栈顶两int型数值大小，当结果小于0时跳转  				a>=b
        //0xa2 if_icmpge    比较栈顶两int型数值大小，当结果大于等于0时跳转
        //0xa3 if_icmpgt    比较栈顶两int型数值大小，当结果大于0时跳转
        //0xa4 if_icmple    比较栈顶两int型数值大小，当结果小于等于0时跳转
        //0xa5 if_acmpeq    比较栈顶两引用型数值，当结果相等时跳转					a != b
        //0xa6 if_acmpne    比较栈顶两引用型数值，当结果不相等时跳转    					a == b
    }

    /**
     * 7.4无条件跳转
     */
    public void testCompareAndGoD()
    {
        //0xa7 goto    无条件跳转
        //0xa8 jsr     跳转至指定16位offset位置，并将jsr下一条指令地址压入栈顶
        //0xa9 ret     返回至本地变量指定的index的指令位置（一般与jsr, jsr_w联合使用）
        //0xaa tableswitch    用于switch条件跳转，case值连续（可变长度指令）
        //0xab lookupswitch    用于switch条件跳转，case值不连续（可变长度指令）

        //0xc8 goto_w    无条件跳转
        //0xc9 jsr_w    跳转至指定32位offset位置，并将jsr_w下一条指令地址压入栈顶
    }

    /**
     * 7.5空值跳转
     */
    public void testComapreAndGoE()
    {
        String str = null;
        if( str == null)
        {
            str = "abc";
        }

        if(str != null)
        {
            str = "efg";
        }
        //0xc6 ifnull    为null时跳转
        //0xc7 ifnonnull    不为null时跳转
    }

    /**
     * 8.返回指令系列
     * 该系列指令用于从函数中返回。如果有返回值的话，都把函数的返回值放在栈道中，以便它的调用方法取得它
     */
    public int testReturn()
    {
        //0xac ireturn    从当前方法返回int
        byte b = 10;
        return b;
        /**
         0: bipush        10		//常量10入栈
         2: istore_1				//栈顶元素存入到本地变量表位置2
         3: iload_1					//本地变量表位置2元素入栈
         4: ireturn					//返回栈顶元素
         */
        //0xad lreturn    从当前方法返回long
        //0xae freturn    从当前方法返回float
        //0xaf dreturn    从当前方法返回double
        //0xb0 areturn    从当前方法返回对象引用
        //0xb1 return    从当前方法返回void
    }

    /**
     * 9.属性操作
     * 域操作指令系列
     * 该系列指令用于对静态域和非静态域进行读写。该系列命令需要跟一个表明域编号的参数
     */
    private final static String name = "dog";
    private static String home;
    private int distance;
    public void testFiled()
    {
        String name2 = name;

        home = "hhhhh";
        String home2 = home;

        this.distance = 100;
        int distance2 = distance;

        /**
         *
         0: ldc           #8   // 常量入栈              // String dog
         2: astore_1		   //存入local_2
         3: ldc           #112 //常量入栈                // String hhhhh
         5: putstatic     #114 //为指定的类的静态域赋值,值为栈顶               // Field home:Ljava/lang/String;
         8: getstatic     #114 //获取指定类的静态域，并将其值压入栈顶               // Field home:Ljava/lang/String;
         11: astore_2		   //栈顶存入local_3
         12: aload_0			   //this入栈------------------------putfield需要指定的对象
         13: bipush        100  //常量入栈
         15: putfield      #116 //获取指定类的实例域，并将其值压入栈顶,需要带入参数(对象和值)               // Field distance:I
         18: aload_0			   //this入栈
         19: getfield      #116 // 获取指定类的实例域，并将其值压入栈顶              // Field distance:I
         22: istore_3		   //栈顶存入local_4
         23: return
         */

        //0xb2 getstatic    获取指定类的静态域，并将其值压入栈顶
        //0xb3 putstatic    为指定的类的静态域赋值
        //0xb4 getfield    获取指定类的实例域，并将其值压入栈顶
        //0xb5 putfield    为指定的类的实例域赋值 需要带入参数需要带入参数(对象和值)
    }

    private void print()
    {

    }

    /**
     * 10.方法操作
     * 该系列指令用于对静态方法和非静方法进行调用。
     * 该系列命令需要跟一个表明方法编号的参数。
     * 如果方法有传入参数的话，则需要先压栈到栈顶。另外，方法的返回参数是保存到栈顶的，因此我们可以通过栈道值取得方法的返回值。
     */
    public void testMethod()
    {

        //invokespecial-实例初始化方法,编译期可确定的方法
        ChinieseDog dog = new ChinieseDog();

        //invokespecial-私有方法,编译期可确定的方法
        this.print();

        //invokestatic    调用静态方法
        ChinieseDog.walk("where");

        //invokevirtual    调用实例方法 动态确定
        dog.eat();
        dog.drink();


        //0xb6 invokevirtual    调用实例方法
        //0xb7 invokespecial    调用超类构造方法，实例初始化方法，私有方法
        //0xb8 invokestatic    调用静态方法
        //0xb9 invokeinterface 调用接口方法
    }

    /**
     * 11.未归类系列 0xba
     */
    public void testNew()
    {
        //0xbb new     创建一个对象，并将其引用值压入栈顶
        String str = new String("9");

        //0xbc newarray    创建一个指定原始类型（如int, float, char…）的数组，并将其引用值压入栈顶
        int[] int_array = new int[10];

        //0xbd anewarray    创建一个引用型（如类，接口，数组）的数组，并将其引用值压入栈顶
        String[] a_array = new String[10];

        //0xbe arraylength 获得数组的长度值并压入栈顶
        int length = a_array.length;

        /**
         *
         0: new           #143   //创建一个对象，并将其引用值压入栈顶             // class java/lang/String
         3: dup					 //复制栈顶元素并压栈
         4: ldc           #145   //常量压栈               // String 9
         6: invokespecial #147   //调用构造方法             // Method java/lang/String."<init>":(Ljava/lang/String;)V
         9: astore_1			 //栈顶元素存入本地变量表
         10: bipush        10	 //常量入栈
         12: newarray       int	 //创建一个指定原始类型（如int, float, char…）的数组，并将其引用值压入栈顶
         14: astore_2			 //栈顶元素存入本地变量表
         15: bipush        10	 //常量入栈
         17: anewarray     #143   //创建一个引用型（如类，接口，数组）的数组，并将其引用值压入栈顶             // class java/lang/String
         20: astore_3			 //栈顶元素存入本地变量表
         21: aload_3				 //本地变量表入栈
         22: arraylength			 //获得数组的长度值并压入栈顶
         23: istore        4		 //栈顶元素存入本地变量表
         25: return
         */
    }

    /**
     * 12.异常指令
     */
    /**
     * 12。1.异常抛出指令
     * @throws Exception
     */
    public void testExceptionA() throws Exception
    {
        //0xbf athrow    将栈顶的异常抛出
        throw new Exception();
    }

    /**
     * 12.2捕获异常指令处理机制
     * @return
     */
    public int testExceptionB()
    {
        try
        {
            int a =1/0;
            return 1;
        }
        catch(Exception e)
        {
            return 2;
        }
        finally
        {
            return 3;
        }
        /**
         *
         Code:
         stack=2, locals=2, args_size=1
         0: iconst_1
         1: iconst_0
         2: idiv
         3: istore_1
         4: goto          12
         7: astore_1
         8: goto          12
         11: pop
         12: iconst_3	//最后不管如何都会是返回3
         13: ireturn
         Exception table:
         from    to  target type
         0     7     7   Class java/lang/Exception  //如果代码0-7行代码异常，跳转到行7执行
         0    11    11   any
         LocalVariableTable:
         Start  Length  Slot  Name   Signature
         0      14     0  this   Ljvm06/TestOrder;
         4       3     1     a   I
         8       3     1     e   Ljava/lang/Exception; //slot的复用
         */
    }

    /**
     * 13.检查指令
     */
    public void testCheck()
    {
        //0xc0 checkcast    检验类型转换，检验未通过将抛出ClassCastException
        //0xc1 instanceof 检验对象是否是指定的类的实例，如果是将1压入栈顶，否则将0压入栈顶
        int[] array = new int[10];
        boolean a = array instanceof int[];
    }

    /**
     * 14.同步指令
     * 同步代码代码块
     */
    public   void testMonitor()
    {
        Object o = new Object();
        synchronized(o)
        {
            int a=0;
        }

        //0xc2 monitorenter    获得对象的锁，用于同步方法或同步块
        //0xc3 monitorexit    释放对象的锁，用于同步方法或同步块
        /**
         *
         0: new           #3                  // class java/lang/Object
         3: dup
         4: invokespecial #16                 // Method java/lang/Object."<init>":()V
         7: astore_1
         8: aload_1
         9: dup
         --------------------new Object(),复制并且压栈
         10: astore_2
         11: monitorenter
         ---------------------获取栈顶元素,此元素即是锁(不知道存在哪个地方了),获取对象的锁
         12: iconst_0
         13: istore_3
         14: aload_2
         15: monitorexit
         ---------------------释放锁
         16: goto          22
         19: aload_2
         20: monitorexit
         21: athrow
         22: return
         Exception table:
         from    to  target type  自动添加异常表，异常下自动抛出锁
         12    16    19   any
         19    21    19   any
         */
    }

    /**
     * 15.创建多维数组
     */
    public void testArray()
    {
        //0xc5 multianewarray 创建指定类型和指定维度的多维数组（执行该指令时，操作栈中必须包含各维度的长度值），并将其引用值压入栈顶
        int[][][] arr = new int[1][2][];
    }
}
