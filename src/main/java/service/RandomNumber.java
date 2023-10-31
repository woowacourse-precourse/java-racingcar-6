package service;

import static util.Constant.END_NUMBER;
import static util.Constant.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
