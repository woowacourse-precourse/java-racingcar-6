package racingcar.Controller;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final static String ERR_NAME_LENGTH = "자동차의 이름은 5자 이하여야 합니다.";
    private final static String ERR_NAME_ALREADY_USED = "이미 등록된 자동차 이름입니다.";
    private final static String ERR_NAME_SPACE_CHAR = "자동차 이름에 공백문자를 사용할수는 없습니다.";
    private final static String ERR_NAME_IS_EMPTY = "자동차의 이름을 입력하세요.";
    private final static String ERR_NAME_NULL_EXCEPTION = "NullPointerException in validCarName.";
    private final static String ERR_LIST_IS_EMPTY = "최소 1개의 자동차 이름을 입력하세요.";
    private final static String ERR_NUM_IS_NOT_NUM = "실행횟수에 숫자를 입력하세요.";
    private final static String ERR_NUM_IS_BELOW_ONE = "실행횟수에 1이상의 숫자를 입력하세요.";
    private Set<String> carNameSet;

    public Validator() {
        this.carNameSet = new HashSet<>();
    }

    public void validCarName(String carName) {
        validNameIsNull(carName);
        validNameMaxLength(carName);
        validNameIsContainSpace(carName);
        validNameIsUnique(carName);
        validNameStringIsEmpty(carName);
    }

    private void validNameIsNull(String carName) {
        if (carName == null){
            throw new NullPointerException(ERR_NAME_NULL_EXCEPTION);
        }
    }

    private void validNameMaxLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_NAME_LENGTH);
        }
    }

    private void validNameIsUnique(String carName) {
        if (carNameSet.contains(carName)) {
            throw new IllegalArgumentException(ERR_NAME_ALREADY_USED);
        }
        carNameSet.add(carName);
    }

    private void validNameIsContainSpace(String carName) {
        for (char spell : carName.toCharArray()) {
            if (Character.isWhitespace(spell)) {
                throw new IllegalArgumentException(ERR_NAME_SPACE_CHAR);
            }
        }
    }

    private void validNameStringIsEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException((ERR_NAME_IS_EMPTY));
        }
    }

    public void validListIsEmpty(List<String> carNameList) {
        if (carNameList == null || carNameList.isEmpty()) {
            throw new IllegalArgumentException(ERR_LIST_IS_EMPTY);
        }
    }

    public int getValidNumber(String tryString) {
        try {
            int intValue = Integer.parseInt(tryString);
            if (intValue < 1) {
                throw new IllegalArgumentException(ERR_NUM_IS_BELOW_ONE);
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_NUM_IS_NOT_NUM);
        }

    }
}

