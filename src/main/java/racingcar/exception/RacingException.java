package racingcar.exception;

import java.util.ArrayList;

public class RacingException {

        public void validateCarNameLen(String carNames) {
            for (String s : carNames.split(",")) {
                if (s.length() > 5) {
                    throw new IllegalArgumentException();
                }
            }
        }
        public void validateLastCharIsComma(String carNames) {
            if (carNames.charAt(carNames.length() - 1) == ',') {
                throw new IllegalArgumentException();
            }
        }
}
