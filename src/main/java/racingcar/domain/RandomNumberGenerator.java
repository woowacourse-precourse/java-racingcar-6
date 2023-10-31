package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain2.CarGame;

import java.util.List;

public class RandomNumberGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;


    public boolean isNumberThanEqualFour() { //Distance 점수 업데이트
        if (makeRandomNumber() >= 4){
            return true;
        }
        return false;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
