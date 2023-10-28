package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class RandomNumberGenorater {
    public static boolean generateRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0,9);

        if(randomNumber >= 4){
            return true;
        }
        else{
            return false;
        }
    }
}
