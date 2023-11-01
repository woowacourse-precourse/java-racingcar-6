package racingcar;

import java.util.regex.Pattern;

public class Validator {

    public static final int MAX_NAME_LENGTH  = 5;
    public static final int MIN_PARTS_LENGTH = 2;

    public void isValidCarNames(String input) {
        String[] parts = input.split(",");
        if (parts.length < MIN_PARTS_LENGTH) {
            throw new IllegalArgumentException("자동차 이름을 쉼표로 구분하여 입력하지 않아 종료됩니다.");
        }
    }

    public void isValidLength(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            String trimmedName = name.trim();
            if(trimmedName.length() > MAX_NAME_LENGTH){
                throw new IllegalArgumentException("자동차 이름이 5자를 초과하여 종료됩니다.");
            }
        }
    }

    public void isValidNumber(String input) {
        String pattern = "^[1-9]*$";
        if (input == null || !Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("시도할 회수를 정수로 입력하지 않아 종료합니다.");
        }
    }

}
