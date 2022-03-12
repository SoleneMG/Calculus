package fr.michelgrosjean.calculus.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.michelgrosjean.calculus.model.Divide2Operation;
import fr.michelgrosjean.calculus.model.Multiply2Operation;
import fr.michelgrosjean.calculus.model.Operation;
import fr.michelgrosjean.calculus.model.Substraction2NegativeOperation;
import fr.michelgrosjean.calculus.model.Substraction2PositiveOperation;
import fr.michelgrosjean.calculus.model.Sum2Operation;
import fr.michelgrosjean.calculus.model.Sum3Operation;

public class AnswersGenerator {
    private Operation operation;
    private final int NB_ANSWERS = 4;
    private List<Integer> answers = new ArrayList<>();
    private int result;

    public AnswersGenerator(Operation operation) {
        this.operation = operation;
        this.result = compute();
    }

    public List<Integer> generateAnswers() {
        int interval = 5;
        List<Integer> numbers = numberGenerator(result, interval, false);
        answers.addAll(numbers);
        answers.add(result);
        Collections.shuffle(answers);
        return answers;
    }
/*
    I use a loop with interval to avoid to use a random number.
    The 1th argument is based on the result but we can imagine increment only the first operands
 */
    private List<Integer> numberGenerator(int number, int interval, boolean allowNegativeValue) {
        List<Integer> numbers = new ArrayList<>();
        do {
            for (int i = number - interval; i < number + interval; i++) {
                if ((i >= 0 || allowNegativeValue) && i != number) {
                    numbers.add(i);
                }
            }
        } while (numbers.size() < (NB_ANSWERS - 1));
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, NB_ANSWERS - 1);
        return numbers;
    }

    public int compute() {
        switch (operation.type) {
            case Sum2Operation:
                Sum2Operation opSum = (Sum2Operation) operation;
                result = opSum.number1 + opSum.number2;
                break;
            case Substraction2PositiveOperation:
                Substraction2PositiveOperation opSubPos = (Substraction2PositiveOperation) operation;
                result = opSubPos.number1 - opSubPos.number2;
                break;
            case Substraction2NegativeOperation:
                Substraction2NegativeOperation opSubNeg = (Substraction2NegativeOperation) operation;
                result = opSubNeg.number1 - opSubNeg.number2;
                break;
            case Multiply2Operation:
                Multiply2Operation opMultiply = (Multiply2Operation) operation;
                result = opMultiply.number1 * opMultiply.number2;
                break;
            case Divide2Operation:
                Divide2Operation opDiv = (Divide2Operation) operation;
                result = opDiv.number1 / opDiv.number2;
                break;
            case Sum3Operation:
                Sum3Operation opSum3 = (Sum3Operation) operation;
                result = opSum3.number1 + opSum3.number2 + opSum3.number3;
                break;
            default:
                throw new IllegalArgumentException("Type not supported");
        }
        return result;
    }
}
