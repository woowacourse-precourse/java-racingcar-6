package racingcar.common.exception;

import racingcar.common.constant.GuidePhrases;

import java.util.List;

public class CarNameHavingEmptyException {
    public static void havingEmpty(List<String> carNames) {
        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException(GuidePhrases.havingEmptyPhrase);
            }
        }
    }
}
