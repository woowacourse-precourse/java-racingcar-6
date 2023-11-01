package racingcar;

import java.util.regex.Pattern;

public class Util {
    public static final Pattern CARS_PATTERN = Pattern.compile("^[a-zA-Z]{1,5}$");
    public static final Pattern ATTEMPT_PATTERN = Pattern.compile("^[1-9]\\d*$");

    public enum OutputMessage {
        INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        CAR_NAME_LENGTH_ERROR_MESSAGE("자동차 이름은 1글자에서 5글자 사이의 알파벳만 가능해요."),
        SAME_CAR_NAME_ERROR_MESSAGE("동일한 이름의 자동차는 입력 할 수 없어요."),
        ATTEMPT_VALUE_ERROR_MESSAGE("횟수는 1 이상의 숫자만 입력이 가능해요.");

        private String message;

        public String getMessage() {
            return message;
        }

        OutputMessage(String message) {
            this.message = message;
        }
    }
}
