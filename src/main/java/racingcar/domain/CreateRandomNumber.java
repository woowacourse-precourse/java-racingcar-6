package racingcar.domain;

import java.util.Random;

public class CreateRandomNumber {
    public int generateRandomNumber(){
        int number = new Random().nextInt(9) + 1;
        return number;
    }
}

