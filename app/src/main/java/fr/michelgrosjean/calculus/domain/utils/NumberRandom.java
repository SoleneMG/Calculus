package fr.michelgrosjean.calculus.domain.utils;

public class NumberRandom {

    public static int generate(int min, int max){
        return (int) (Math.random() * max) + min;
    }

}
