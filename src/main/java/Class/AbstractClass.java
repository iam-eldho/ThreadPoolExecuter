package Class;

public abstract class AbstractClass { // abstract class

    public abstract int getInterestRate(); // abstract method

    public abstract void calculate(); // abstract method

    public int getFixedInterestRate() { // non abstract method
        return 7;
    }
}

class ConcreteClass2 extends AbstractClass {
    @Override
    public int getInterestRate() {
        return 0;
    }

    @Override
    public void calculate() {
        // Todo
    }
}
