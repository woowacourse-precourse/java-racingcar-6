package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {

    private int randomNumber;

    private GenerateRandomNumber(){
        generateRandomNumber();
    }

    private void generateRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    public int getRandomNumber(){
        generateRandomNumber();
        return randomNumber;
    }
    
    public static GenerateRandomNumber create() {
        return new GenerateRandomNumber();
    }
}