package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int RandomNumber(){
        int num= Randoms.pickNumberInRange(0,9);
        return num;
    }
}
