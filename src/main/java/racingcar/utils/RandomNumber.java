package racingcar.utils;

import java.util.Random;

public class RandomNumber {

    static Random random = new Random();

    public static int getRandomNumber(){
        return random.nextInt(9)+1;
    }
}
