package racingcar.common.exception;

import racingcar.common.constant.GuidePhrases;

import java.util.List;

public class CarNameLengthException {
    public static void nameLengthWrong(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() < 1) {
                throw new IllegalArgumentException(GuidePhrases.wrongLengthPhrase);
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException(GuidePhrases.wrongLengthPhrase);
            }
        }
    }
}
