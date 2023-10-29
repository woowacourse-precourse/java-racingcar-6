package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    public static Integer CreateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
