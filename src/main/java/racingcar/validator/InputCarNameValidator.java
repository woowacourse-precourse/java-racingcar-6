package racingcar.validator;

import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import racingcar.util.ConverterUtil;

public class InputCarNameValidator {
    private static final int CAR_NAME_MAX_LENTH = 5;
    private static final int FIRST_CAR_NAME_INDEX = 0;
    private static final char COMMA = ',';

    public void validateCarName(String carNames) {
        if (!isCorrectCarLength(carNames)) {
            throw new IllegalArgumentException("자동차이름은 1~5자이하여야 합니다.");
        }
        if (isContainBlank(carNames)) {
            throw new IllegalStateException("자동차 이름에 공백이 있으면 안됩니다.");
        }
        if (isOverlapCarName(carNames)) {
            throw new IllegalStateException("중복된 자동차를 입력하였습니다.");
        }
        if (isStartComma(carNames)) {
            throw new IllegalStateException("쉼표(,)로 시작하면 안됩니다.");
        }
    }

    public boolean isCorrectCarLength(String carNames) {
        List<String> cars = ConverterUtil.covertStringToList(carNames);
        for (String car : cars) {
            if (car.length() > CAR_NAME_MAX_LENTH) {
                return false;
            }
        }
        return true;
    }

    public boolean isContainBlank(String carNames) {
        return carNames.contains(" ");
    }

    public boolean isOverlapCarName(String carNames) {
        List<String> cars = ConverterUtil.covertStringToList(carNames);
        HashSet<String> overlapNames = new HashSet<>();
        for (String car : cars) {
            if (!overlapNames.add(car)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStartComma(String carNames) {
        return carNames.charAt(FIRST_CAR_NAME_INDEX) == COMMA;

    }
}
