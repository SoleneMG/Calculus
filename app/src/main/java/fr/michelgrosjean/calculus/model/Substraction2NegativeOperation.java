package fr.michelgrosjean.calculus.model;

public class Substraction2NegativeOperation extends Operation {
    public final int number1, number2;

    public Substraction2NegativeOperation(int number1, int number2) {
        super(Type.Substraction2PositiveOperation);
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public int result() {
        return number1 - number2;
    }
}
