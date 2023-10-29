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

        public void validateIsNullAfterComma(String carNames) {
            for (int i = 0; i < carNames.length()-1; i++) {
                if (carNames.charAt(i) == ',' && carNames.charAt(i + 1) == ' ') {
                    throw new IllegalArgumentException("이름 간 공백없이 작성하시오.");
                }
            }
        }
}
