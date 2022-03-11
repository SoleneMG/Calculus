package fr.michelgrosjean.calculus.model;

public class Sum3Operation extends Operation {
    public final int number1, number2, number3;

    public Sum3Operation(int number1, int number2, int number3){
        super(Type.Sum3Operation);
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    @Override
    public int result() {
        return number1+number2+number3;
    }
}
