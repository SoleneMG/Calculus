package fr.michelgrosjean.calculus.model;

public abstract class Operation {
    public Type type;

    public Operation(Type type){
        this.type = type;
    }

    public enum Type {
        Substraction2PositiveOperation,
        Sum2Operation,
        MultiplyOperation,
        Sum3Operation
    }

    abstract public int result();

}
