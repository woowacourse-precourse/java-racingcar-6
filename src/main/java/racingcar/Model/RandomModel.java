package racingcar.Model;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomModel {
    static final Integer NUMBER_RANGE_ZERO = 0;
    static final Integer NUMBER_RANGE_LAST = 9;
    static final Integer CONDITION_FOR_TRUE = 4;

    public static boolean checkRandomNumber(){
       if(makeRandomNumber() >= CONDITION_FOR_TRUE)
           return true;
       return false;
    }
    public static Integer makeRandomNumber(){
        Integer rands = Randoms.pickNumberInRange(NUMBER_RANGE_ZERO,NUMBER_RANGE_LAST);
        return rands;
    }

}
