package fr.michelgrosjean.calculus.model;

public abstract class Operation {
    public Type type;

    public Operation(Type type){
        this.type = type;
    }

    public enum Type {
        Substraction2PositiveOperation,
        Substraction2NegativeOperation,
        Sum2Operation,
        Multiply2Operation,
        Sum3Operation,
        Divide2Operation
    }

    abstract public int result();

}
