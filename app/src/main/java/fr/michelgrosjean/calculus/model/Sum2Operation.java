package fr.michelgrosjean.calculus.model;

public class Sum2Operation extends Operation {
    public final int number1, number2;

    public Sum2Operation(int number1, int number2){
        super(Operation.Type.Sum2Operation);
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public int result() {
        return number1+number2;
    }
}
