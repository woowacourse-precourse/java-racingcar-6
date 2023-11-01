package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameConfig;

import static racingcar.constant.GameConfig.*;

public class GameUtils {
    private final int ZERO = GameConfig.ZERO.getValue();
    private final int MIN_RANDOM_NUM = GameConfig.MIN_RANDOM_NUM.getValue();
    private final int MAX_RANDOM_NUM = GameConfig.MAX_RANDOM_NUM.getValue();
    private final int MIN_DISTANCE = GameConfig.MIN_DISTANCE.getValue();

    public List<String> splitByComma(String userInput) {
        final String SEPARATE_REGEX = ",";
        return Arrays.asList(userInput.split(SEPARATE_REGEX));
    }

    public int makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        if (randomNumber >= MIN_DISTANCE) {
            return randomNumber;
        }
        return ZERO;
    }
}
