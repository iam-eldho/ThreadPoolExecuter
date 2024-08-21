package Class;

public class ObjectTest {
    public static void main(String[] args) {
        Object obj = new Person();
        System.out.println(obj.getClass());

    }
}

class Person {
    String name;
    int age;
}
