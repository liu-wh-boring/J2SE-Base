package chapter08.jvm;

public class T02_ClassFile
{
    public final static String dog =  "中华田园犬";

    static Integer age=3;

    double price;

    private T02_ClassFile(double price)
    {
        this.price = price;
    }

    public Integer getAge()
    {
        return age;
    }

    void setInfo(Integer age,double price)
    {
        T02_ClassFile.age = age;
        this.price = price;

        try
        {
            int counter = 1/0;
        }
        catch(Exception e)
        {

        }
    }

    /**
     * javap -verbose TestClass2
     */
    /**
     *
     Classfile /D:/study/jvm/bin/org/fenixsoft/TestClass2.class
     Last modified 2019-3-2; size 909 bytes
     MD5 checksum c4096c56204918e6edbaf727d3bb8bf5
     Compiled from "TestClass2.java"
     public class org.fenixsoft.TestClass2
     minor version: 0
     major version: 52
     flags: ACC_PUBLIC, ACC_SUPER
     Constant pool:
     #1 = Class              #2             // org/fenixsoft/TestClass2
     #2 = Utf8               org/fenixsoft/TestClass2
     #3 = Class              #4             // java/lang/Object
     #4 = Utf8               java/lang/Object
     #5 = Utf8               dog
     #6 = Utf8               Ljava/lang/String;
     #7 = Utf8               ConstantValue
     #8 = String             #9             // ����һ����
     #9 = Utf8               ����һ����
     #10 = Utf8               age
     #11 = Utf8               Ljava/lang/Integer;
     #12 = Utf8               price
     #13 = Utf8               D
     #14 = Utf8               <clinit>
     #15 = Utf8               ()V
     #16 = Utf8               Code
     #17 = Methodref          #18.#20        // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     #18 = Class              #19            // java/lang/Integer
     #19 = Utf8               java/lang/Integer
     #20 = NameAndType        #21:#22        // valueOf:(I)Ljava/lang/Integer;
     #21 = Utf8               valueOf
     #22 = Utf8               (I)Ljava/lang/Integer;
     #23 = Fieldref           #1.#24         // org/fenixsoft/TestClass2.age:Ljava/lang/Integer;
     #24 = NameAndType        #10:#11        // age:Ljava/lang/Integer;
     #25 = Utf8               LineNumberTable
     #26 = Utf8               LocalVariableTable
     #27 = Utf8               <init>
     #28 = Utf8               (D)V
     #29 = Methodref          #3.#30         // java/lang/Object."<init>":()V
     #30 = NameAndType        #27:#15        // "<init>":()V
     #31 = Fieldref           #1.#32         // org/fenixsoft/TestClass2.price:D
     #32 = NameAndType        #12:#13        // price:D
     #33 = Utf8               this
     #34 = Utf8               Lorg/fenixsoft/TestClass2;
     #35 = Utf8               getAge
     #36 = Utf8               ()Ljava/lang/Integer;
     #37 = Utf8               setInfo
     #38 = Utf8               (Ljava/lang/Integer;D)V
     #39 = Class              #40            // java/lang/Exception
     #40 = Utf8               java/lang/Exception
     #41 = Utf8               StackMapTable
     #42 = Utf8               SourceFile
     #43 = Utf8               TestClass2.java
     {
     public static final java.lang.String dog;
     descriptor: Ljava/lang/String;
     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL
     ConstantValue: String ����һ����

     static java.lang.Integer age;
     descriptor: Ljava/lang/Integer;
     flags: ACC_STATIC

     double price;
     descriptor: D
     flags:

     static {};
     descriptor: ()V
     flags: ACC_STATIC
     Code:
     stack=1, locals=0, args_size=0
     0: iconst_3
     1: invokestatic  #17                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     4: putstatic     #23                 // Field age:Ljava/lang/Integer;
     7: return
     LineNumberTable:
     line 7: 0
     LocalVariableTable:
     Start  Length  Slot  Name   Signature

     public java.lang.Integer getAge();
     descriptor: ()Ljava/lang/Integer;
     flags: ACC_PUBLIC
     Code:
     stack=1, locals=1, args_size=1
     0: getstatic     #23                 // Field age:Ljava/lang/Integer;
     3: areturn
     LineNumberTable:
     line 18: 0
     LocalVariableTable:
     Start  Length  Slot  Name   Signature
     0       4     0  this   Lorg/fenixsoft/TestClass2;

     void setInfo(java.lang.Integer, double);
     descriptor: (Ljava/lang/Integer;D)V
     flags:
     Code:
     stack=3, locals=5, args_size=3
     0: aload_1
     1: putstatic     #23                 // Field age:Ljava/lang/Integer;
     4: aload_0
     5: dload_2
     6: putfield      #31                 // Field price:D
     9: iconst_1
     10: iconst_0
     11: idiv
     12: istore        4
     14: goto          19
     17: astore        4
     19: return
     Exception table:
     from    to  target type
     9    14    17   Class java/lang/Exception
     LineNumberTable:
     line 23: 0
     line 24: 4
     line 28: 9
     line 29: 14
     line 30: 17
     line 34: 19
     LocalVariableTable:
     Start  Length  Slot  Name   Signature
     0      20     0  this   Lorg/fenixsoft/TestClass2;
     0      20     1   age   Ljava/lang/Integer;
     0      20     2 price   D
     StackMapTable: number_of_entries = 2
     frame_type = 81 // same_locals_1_stack_item
     stack = [ class java/lang/Exception ]
     frame_type = 1 // same
     }
     SourceFile: "TestClass2.java"
     */
    /**
     * �ֽ���
     */
    /**
     CA FE BA BE magic number
     00 00 minor version
     00 34 major version
     00 2C constant_pool_number = 43

     ---constant pool
     #01 07 00 02
     #02 01 00 18 6F 72 67 2F 66 65 6E 69 78 73 6F 66 74 2F 54 65 73 74 43 6C 61 73 73 32
     #03 07 00 04
     #04 01 00 10 6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74
     #05 01 00 03 64 6F 67
     #06 01 00 12 4C 6A 61 76 61 2F 6C 61 6E 67 2F 53 74 72 69 6E 67 3B
     #07 01 00 0D 43 6F 6E 73 74 61 6E 74 56 61 6C 75 65
     #08 08 00 09
     #09 01 00 0F E6 88 91 E6 98 AF E4 B8 80 E6 9D A1 E7 8B 97
     #10 01 00 03 61 67 65
     #11 01 00 13 4C  6A 61 76 61 2F 6C 61 6E 67 2F 49 6E 74 65 67 65 72 3B
     #12 01 00 05 70 72 69 63 65
     #13 01 00 01 44
     #14 01 00 08 3C 63 6C 69 6E 69 74 3E
     #15 01 00 03 28 29 56
     #16 01 00 04 43 6F 64 65
     #17 0A 00 12 00 14
     #18 07 00 13
     #19 01 00 11 6A 61 76 61 2F 6C 61 6E 67 2F 49 6E 74 65 67 65 72
     #20 0C 00 15 00 16
     #21 01 00 07 76 61 6C 75 65 4F 66
     #22 01 00 16 28 49 29 4C 6A 61 76 61 2F 6C 61 6E 67 2F 49 6E 74 65 67 65 72 3B
     #23 09 00 01 00 18
     #24 0C 00 0A 00 0B
     #25 01 00 0F 4C 69 6E 65 4E 75 6D 62 65 72 54 61 62 6C 65
     #26 01 00 12 4C 6F 63 61 6C 56 61 72 69 61 62 6C 65 54 61 62 6C 65
     #27 01 00 06 3C 69 6E 69 74 3E
     #28 01 00 04 28 44 29 56
     #29 0A 00 03 00 1E
     #30 0C 00 1B 00 0F
     #31 09 00 01 00 20
     #32 0C 00 0C 00 0D
     #33 01 00 04 74 68 69 73
     #34 01 00 1A 4C 6F 72 67 2F 66 65 6E 69 78 73 6F 66 74 2F 54 65 73 74 43 6C 61 73 73 32 3B
     #35 01 00 06 67 65 74 41 67 65
     #36 01 00 15 28 29 4C 6A 61 76 61 2F 6C 61 6E 67 2F 49 6E 74 65 67 65 72 3B
     #37 01 00 07 73 65 74 49 6E 66 6F
     #38 01 00 17 28 4C 6A 61 76 61 2F 6C 61 6E 67 2F 49 6E 74 65 67 65 72 3B 44 29 56
     #39 07 00 28
     #40 01 00 13 6A 61 76 61 2F 6C 61 6E 67 2F 45 78 63 65 70 74 69 6F 6E
     #41 01 00 0D 53 74 61 63 6B 4D 61 70 54 61 62 6C 65
     #42 01 00 0A 53 6F 75 72 63 65 46 69 6C 65
     #43 01 00 0F 54 65 73 74 43 6C 61 73 73 32 2E 6A 61 76 61

     --class access flag
     00 21 ACC_PUBLIC ACC_SUPER

     --this class
     00 01

     --super class
     00 03

     --interface count
     00 00

     --field count
     00 03

     ----field info   #1
     00 19 ACC_PUBLIC + ACC_FINAL +ACC_STATIC
     00 05 #5 dog
     00 06 #6 Ljava.lang.String
     00 01 attribute count
     --------Attribute table
     00 07 #Constant value
     00 00 00 02 #table length=2
     00 08 # ����һ����

     ----field info  #2
     00 08 ACC_STATIC
     00 0A #10 age
     00 0B #11 Ljava.lang.Integer
     00 00 attribute count=0

     ----field info #3
     00 00 default
     00 0C price
     00 0D double
     00 00 attribute count=0

     --method count
     00 04

     -----method info #1
     00 08 ACC_STATIC
     00 0E #14 clinit
     00 0F #15 ()viod
     00 01 00 10 00 00
     00 28 00 01 00 00 00 00  00 08 06 B8 00 11 B3 00
     17 B1 00 00 00 02 00 19  00 00 00 06 00 01 00 00
     00 07 00 1A 00 00 00 02  00 00 00 02 00 1B 00 1C
     00 01 00 10 00 00 00 46  00 03 00 03 00 00 00 0A
     2A B7 00 1D 2A 27 B5 00  1F B1 00 00 00 02 00 19
     00 00 00 0E 00 03 00 00  00 0B 00 04 00 0D 00 09
     00 0E 00 1A 00 00 00 16  00 02 00 00 00 0A 00 21
     00 22 00 00 00 00 00 0A  00 0C 00 0D 00 01 00 01
     00 23 00 24 00 01 00 10  00 00 00 2E 00 01 00 01
     00 00 00 04 B2 00 17 B0  00 00 00 02 00 19 00 00
     00 06 00 01 00 00 00 12  00 1A 00 00 00 0C 00 01
     00 00 00 04 00 21 00 22  00 00 00 00 00 25 00 26
     00 01 00 10 00 00 00 7B  00 03 00 05 00 00 00 14
     2B B3 00 17 2A 28 B5 00  1F 04 03 6C 36 04 A7 00
     05 3A 04 B1 00 01 00 09  00 0E 00 11 00 27 00 03
     00 19 00 00 00 1A 00 06  00 00 00 17 00 04 00 18
     00 09 00 1C 00 0E 00 1D  00 11 00 1E 00 13 00 22
     00 1A 00 00 00 20 00 03  00 00 00 14 00 21 00 22
     00 00 00 00 00 14 00 0A  00 0B 00 01 00 00 00 14
     00 0C 00 0D 00 02 00 29  00 00 00 07 00 02 51 07
     00 27 01 00 01 00 2A 00  00 00 02 00 2B
     *
     */
}
