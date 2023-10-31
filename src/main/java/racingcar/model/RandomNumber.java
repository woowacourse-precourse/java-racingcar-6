package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private int randomNumber;
    public void generateRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(0,9);
    }
    public int getRandomNumber(){
        return randomNumber;
    }
}
