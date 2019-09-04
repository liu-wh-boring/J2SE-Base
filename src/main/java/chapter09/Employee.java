package chapter09;

public class Employee
{
    private String  name;

    private int age;

    public Employee()
    {

    }

    public Employee(String name)
    {
        this.name = name;
    }

    public Employee(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name="+name+";age="+age;
    }
}
