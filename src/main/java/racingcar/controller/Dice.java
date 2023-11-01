package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.controller.constants.IntegerConstants.*;

public class Dice {
    public boolean isCarCanGoForward(){
        return makeRandomNumber() >= THRESHOLD_VALUE.getValue();
    }

    private Integer makeRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue());
    }
}
