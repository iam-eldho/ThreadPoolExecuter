package Class;

public class WrapperClass {

    public static void main(String[] args) {
        Integer id = 10;
        WrapperClass wrapperClass = new WrapperClass();
        wrapperClass.accept(id);
        System.out.println(id);
    }

    public void accept(Integer number){
        number = 15;
    }
}
