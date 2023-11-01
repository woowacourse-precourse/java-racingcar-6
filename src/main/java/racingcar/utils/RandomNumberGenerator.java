package racingcar.utils;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;


    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM,MAX_RANDOM_NUM);
    }
}
