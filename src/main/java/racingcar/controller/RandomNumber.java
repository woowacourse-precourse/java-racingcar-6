package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utility.Constants.MIN_RANDOM_NUMBER;
import static racingcar.utility.Constants.MAX_RANDOM_NUMBER;

public class RandomNumber {
    private RandomNumber(){} //생성자로 클래스 생성 못하도록 막기
    public static int generateRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
