package racingcar.Model;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomModel {
    public static boolean checkRandomNumber(){
       if(makeRandomNumber() >= 4)
           return true;
       return false;
    }
    public static Integer makeRandomNumber(){
        Integer rands = Randoms.pickNumberInRange(0,9);
        return rands;
    }

}
