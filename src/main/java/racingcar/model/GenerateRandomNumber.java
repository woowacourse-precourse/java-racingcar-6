package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {

    public int randomNumber;

    public int generateRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

}