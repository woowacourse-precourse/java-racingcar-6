package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int startNun = 0;
    private static final int endNum = 9;
    private int randomNumber;
    public RandomNumber(){
        createRandomNumber();
    }
    public void createRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(startNun,endNum);
    }
    public int getRandomNumber(){
        return randomNumber;
    }
}
