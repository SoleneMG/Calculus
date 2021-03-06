package fr.michelgrosjean.calculus.model;

public class Substraction2PositiveOperation extends Substraction2Operation {
    public final int number1, number2;

    public Substraction2PositiveOperation(int number1, int number2) {
        super(Type.Substraction2PositiveOperation);
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public int result() {
        return number1 - number2;
    }
}
