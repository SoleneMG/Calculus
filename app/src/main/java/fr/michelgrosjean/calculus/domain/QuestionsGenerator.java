package fr.michelgrosjean.calculus.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.michelgrosjean.calculus.domain.utils.NumberRandom;
import fr.michelgrosjean.calculus.model.Difficulty;
import fr.michelgrosjean.calculus.model.Divide2Operation;
import fr.michelgrosjean.calculus.model.Multiply2Operation;
import fr.michelgrosjean.calculus.model.Operation;
import fr.michelgrosjean.calculus.model.Substraction2NegativeOperation;
import fr.michelgrosjean.calculus.model.Substraction2Operation;
import fr.michelgrosjean.calculus.model.Substraction2PositiveOperation;
import fr.michelgrosjean.calculus.model.Sum2Operation;
import fr.michelgrosjean.calculus.model.Sum3Operation;

public class QuestionsGenerator {
    /*
     I create 3 list of operation that contains type of operation to generate questions based on difficulty.
     */
    private final List<Operation.Type> easyOperations = new ArrayList<>(Arrays.asList(Operation.Type.Sum2Operation, Operation.Type.Substraction2PositiveOperation));
    private final List<Operation.Type> mediumOperations = new ArrayList<>(Arrays.asList(Operation.Type.Sum3Operation, Operation.Type.Multiply2Operation, Operation.Type.Substraction2NegativeOperation));
    private final List<Operation.Type> hardOperations = new ArrayList<>(Arrays.asList(Operation.Type.Sum3Operation, Operation.Type.Multiply2Operation, Operation.Type.Divide2Operation));


    public List<Operation> generateQuestions (int numberMaxQuestion, Difficulty difficulty) {
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < numberMaxQuestion; i++) {
            switch (difficulty){
                case EASY:
                    operations.add(generateEasyOperation());
                    break;
                case MEDIUM:
                    operations.add(generateMediumOperation());
                    break;
                case HARD:
                    operations.add(generateHardOperation());
                    break;
            }
        }
        return operations;
    }
/*
 I choose to create 3 functions generateEasy, generateMedium and generateHardOperation to make the code clearer
 I use a random value to pick an operation type in the list of easyOperation
 */
    private Operation generateEasyOperation() {
        int index = NumberRandom.generate(0, easyOperations.size());
        switch (easyOperations.get(index)) {
            case Sum2Operation:
                return generateSum2Operation(1, 10, 1, 10);
            case Substraction2PositiveOperation:
                return generateSubstraction2Operation(1, 10, 1, 10, true);
            default:
                throw new IllegalArgumentException("Easy operation not supported");
        }
    }

    private Operation generateMediumOperation() {
        int index = NumberRandom.generate(0, mediumOperations.size());
        switch (mediumOperations.get(index)) {
            case Sum3Operation:
                return generateSum3Operation(1, 40, 1, 40, 1, 40);
            case Multiply2Operation:
                return generateMultiply2Operation(1, 10, 1, 10);
            case Substraction2PositiveOperation:
                return generateSubstraction2Operation(1, 10, 1, 10, false);
            case Substraction2NegativeOperation:
                return generateSubstraction2Operation(1, 40, 1, 40, true);
            default:
                throw new IllegalArgumentException("Medium operation not supported");
        }
    }

    private Operation generateHardOperation() {
        int index = NumberRandom.generate(0, hardOperations.size());
        switch (hardOperations.get(index)) {
            case Sum3Operation:
                return generateSum3Operation(1, 100, 1, 100, 1, 100);
            case Multiply2Operation:
                return generateMultiply2Operation(1, 50, 1, 50);
            case Divide2Operation:
                return generateDivide2Operation(1, 50, 1, 50);
            case Substraction2NegativeOperation:
                return generateSubstraction2Operation(1, 200, 1, 200, false);
            default:
                throw new IllegalArgumentException("Hard operation not supported");
        }
    }

    private Sum2Operation generateSum2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2) {
        return new Sum2Operation(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2));
    }

    private Substraction2Operation generateSubstraction2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2, boolean isPositiveOperation) {
        int number1 = NumberRandom.generate(minNumber1, maxNumber1);
        int number2 = NumberRandom.generate(minNumber2, maxNumber2);
        if (!isPositiveOperation) {
            return new Substraction2NegativeOperation(Math.min(number1, number2), Math.max(number1,number2));
        } else {
            return new Substraction2PositiveOperation(Math.max(number1, number2), Math.min(number1,number2));
        }
    }

    private Multiply2Operation generateMultiply2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2) {
        return new Multiply2Operation(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2));
    }

    private Divide2Operation generateDivide2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2) {
        int number1 = NumberRandom.generate(minNumber1, maxNumber1);
        int number2 = NumberRandom.generate(minNumber2, maxNumber2);
        int result = number1 * number2;
        return new Divide2Operation(result, number1);
    }

    private Sum3Operation generateSum3Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2, int minNumber3, int maxNumber3) {
        return new Sum3Operation(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2), NumberRandom.generate(minNumber3, maxNumber3));
    }
}
