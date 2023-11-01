package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
     public static Integer randomNumber() {
         return Randoms.pickNumberInRange(0, 9);
    }
}
