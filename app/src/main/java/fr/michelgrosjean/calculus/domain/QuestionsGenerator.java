package fr.michelgrosjean.calculus.domain;

import fr.michelgrosjean.calculus.domain.utils.NumberRandom;
import fr.michelgrosjean.calculus.model.Divide2Operation;
import fr.michelgrosjean.calculus.model.Multiply2Operation;
import fr.michelgrosjean.calculus.model.Substraction2NegativeOperation;
import fr.michelgrosjean.calculus.model.Substraction2Operation;
import fr.michelgrosjean.calculus.model.Substraction2PositiveOperation;
import fr.michelgrosjean.calculus.model.Sum2Operation;
import fr.michelgrosjean.calculus.model.Sum3Operation;

public class QuestionsGenerator {

    private Sum2Operation generateSum2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2) {
        return new Sum2Operation(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2));
    }

    private Substraction2Operation generateSubstraction2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2, boolean isPositiveOperation) {
        if (!isPositiveOperation) {
            return new Substraction2NegativeOperation(
                    Math.min(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2))
                    , Math.max(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2)));
        } else {
            return new Substraction2PositiveOperation(
                    Math.max(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2))
                    , Math.min(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2)));
        }
    }

    private Multiply2Operation generateMultiply2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2) {
        return new Multiply2Operation(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2));
    }

    public Divide2Operation generateDivide2Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2) {
        int number1 = NumberRandom.generate(minNumber1, maxNumber1);
        int number2 = NumberRandom.generate(minNumber2, maxNumber2);
        int result = number1 * number2;
        return new Divide2Operation(result, number1);
    }

    private Sum3Operation generateSum3Operation(int minNumber1, int maxNumber1, int minNumber2, int maxNumber2, int minNumber3, int maxNumber3) {
        return new Sum3Operation(NumberRandom.generate(minNumber1, maxNumber1), NumberRandom.generate(minNumber2, maxNumber2), NumberRandom.generate(minNumber3, maxNumber3));
    }


}
