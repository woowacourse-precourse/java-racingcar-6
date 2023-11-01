package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {

    public int randomNumber;

    // public GenerateRandomNumber(){
    //     generateRandomNumber();
    // }

    public int generateRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    // public int getRandomNumber(){
    //     generateRandomNumber();
    //     return randomNumber;
    // }
    
    // public static GenerateRandomNumber create() {
    //     return new GenerateRandomNumber();
    // }

}