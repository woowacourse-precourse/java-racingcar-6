package racingcar.util;

import java.util.List;

public class CarNameValidator {
    private static final int MIN_CARLIST_NUMBER = 2;
    private static final int MAX_CARNAME_LENGTH = 5;

    public static void validateNotSame(List<String> carList) {
        String checkName = carList.get(0);
        for (int i = 1; i < carList.size(); i++) {
            if (carList.get(i).equals(checkName)) {
                throw new IllegalArgumentException(Message.EXCEPTION_CARNAME_SAME.message);
            }
        }
    }

    public static void validateContainBlank(List<String> carList) {
        for (String carName : carList) {
            if(carName.contains(" ")) {
                throw new IllegalArgumentException(Message.EXCEPTION_BLANK.message);
            }
        }
    }

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
        validateNotSame(names);
        validateContainBlank(names);
        names.forEach(CarNameValidator::validateCarNameLength);
    }

    public enum Message {
        EXCEPTION_CAR_NUMBER("자동차의 이름을 2개 이상 입력해주세요."),
        EXCEPTION_CARNAME_LENGTH("자동차의 이름을 5자 이하로 입력해주세요."),
        EXCEPTION_BLANK("이름엔 공백이 들어갈 수 없습니다."),
        EXCEPTION_CARNAME_SAME("중복된 이름이 존재합니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
