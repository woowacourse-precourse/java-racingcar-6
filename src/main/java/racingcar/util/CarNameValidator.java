package racingcar.util;

import java.util.List;

public class CarNameValidator {
    private static final int MIN_CARLIST_NUMBER = 2;
    private static final int MAX_CARNAME_LENGTH = 5;

    private static void validateCarNumber(List<String> names) {
        if (names.size() < MIN_CARLIST_NUMBER) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NUMBER.message);
        }
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > MAX_CARNAME_LENGTH) {
            throw new IllegalArgumentException(Message.EXCEPTION_CARNAME_LENGTH.message);
        }
    }

    public static void validate(List<String> names) {
        validateCarNumber(names);
        names.forEach(CarNameValidator::validateCarNameLength);
    }

    public enum Message {
        EXCEPTION_CAR_NUMBER("자동차의 이름을 2개 이상 입력해주세요."),
        EXCEPTION_CARNAME_LENGTH("자동차의 이름을 5자 이하로 입력해주세요.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
