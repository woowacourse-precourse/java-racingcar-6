package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.GameConfig.*;
public class GameUtils {
    public List<String> splitByComma(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public int makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUM.getValue(), MAX_RANDOM_NUM.getValue());
        if (randomNumber > MAX_CAR_NAME_LENGTH.getValue()) {
            return randomNumber;
        }
        return ZERO.getValue();
    }
}
