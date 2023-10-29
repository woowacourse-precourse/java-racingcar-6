package racingcar.validator;

import static racingcar.constant.DefaultValidatorConstant.DEFAULT_CAR_NAME_DUPLICATION_POLICY;
import static racingcar.constant.DefaultValidatorConstant.DEFAULT_MAX_CAR;
import static racingcar.constant.DefaultValidatorConstant.DEFAULT_MAX_EXECUTION_COUNT;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private int maxCar = DEFAULT_MAX_CAR;
    private int maxExecutionCount = DEFAULT_MAX_EXECUTION_COUNT;
    private boolean allowCarNameDuplication = DEFAULT_CAR_NAME_DUPLICATION_POLICY;

    public String validateInputCarName(String input) {
        checkForm(input);

        if (!allowCarNameDuplication) {
            checkDuplication(input);
        }
        return input;
    }

    public String validateInputCount(String input) {
        //숫자만 허용(0 ~ 99,999,999)
        if (!Pattern.matches("^(?:[1-9]\\d{0,7}|0)$", input)) {
            throw new IllegalArgumentException();
        }

        int count = Integer.parseInt(input);
        if (count < 1 || count > maxExecutionCount) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private void checkForm(String input) {
        //자동차의 이름은 5자 이하만 허용
        //자동차의 이름은 영어, 숫자만 하용
        //자동차의 수는 최소 1대, 최대 (maxCar)대까지 허용
        if (!Pattern.matches("^(\\w{1,5})(,\\w{1,5}){0," + (maxCar - 1) + "}$", input)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(String input) {
        List<String> list = Arrays.asList(input.split(","));
        List<String> distinctList = list.stream()
                .distinct()
                .toList();

        if (list.size() != distinctList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void setMaxCar(int maxCar) {
        this.maxCar = maxCar;
    }

    public void setMaxExecutionCount(int maxExecutionCount) {
        this.maxExecutionCount = maxExecutionCount;
    }

    public void setAllowCarNameDuplication(boolean allowCarNameDuplication) {
        this.allowCarNameDuplication = allowCarNameDuplication;
    }
}
