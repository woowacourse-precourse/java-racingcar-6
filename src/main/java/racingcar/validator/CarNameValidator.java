package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;

public class CarNameValidator {

    private final String name;
    public final ArrayList<String> names;
    private final static String NAME_ERROR_MESSAGE = "차 이름은 문자로만 구성되어야 합니다.";
    private final static String NAME_NULL_ERROR_MESSAGE = "차 이름을 적어주세요.";
    private final static String NAME_RANGE_ERROR_MESSAGE = "차 이름은 1자 이상 5자 이하로 적어주세요.";
    private final static String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름을 적으면 안 됩니다.";
    private final static String ONE_CAR_ERROR_MESSAGE = "두 대 이상의 차를 입력하세요.";
    private final static int MAX_LENGTH = 5;
    private final static int MIN_LENGTH = 1;

    public CarNameValidator(String input) {
        name = input;
        names = new ArrayList<>(Arrays.asList(input.split(",")));
        isNull();
        isNameError();
        isRangeOut();
        isOneCar();
        isDuplicate();
    }

    public void isNull() {
        if (name.equals("")) {
            throw new IllegalArgumentException(NAME_NULL_ERROR_MESSAGE);
        }
    }

    public void isNameError() {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    public void isRangeOut() {
        for (String name : names) {
            if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
                throw new IllegalArgumentException(NAME_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public void isOneCar() {
        if (names.size() < 2) {
            throw new IllegalArgumentException(ONE_CAR_ERROR_MESSAGE);
        }
    }

    public void isDuplicate() {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}