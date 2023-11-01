package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int RACE_CAR_LENGTH = 2;
    private static final int RACE_CARNAME_LENGTH = 5;
    private static final String WRONG_SIZE_CAR_MESSAGE = "2대 이상의 자동차 이름을 입력해주세요.";
    private static final String WRONG_NULL_CARNAME_MESSAGE = "공백이 아닌 자동차 이름을 입력해주세요.";
    private static final String WRONG_RANGE_CARNAME_MESSAGE = "5 이하의 자동차 이름을 입력해주세요.";
    private static final String WRONG_SAME_CARNAME_MESSAGE = "서로 다른 자동차 이름을 입력해주세요.";

    public List<String> toValidateCarName(List<String> carName) {
        if (!isBigRaceCarLength(carName)) {
            throw new IllegalArgumentException(WRONG_SIZE_CAR_MESSAGE);
        } else if (!isNullCarName(carName)) {
            throw new IllegalArgumentException(WRONG_NULL_CARNAME_MESSAGE);
        } else if (!isSmallCarNameLength(carName)) {
            throw new IllegalArgumentException(WRONG_RANGE_CARNAME_MESSAGE);
        } else if (!isDiifCarName(carName)) {
            throw new IllegalArgumentException(WRONG_SAME_CARNAME_MESSAGE);
        }

        return carName;
    }

    private boolean isBigRaceCarLength(List<String> carNames) {
        return carNames.size() >= RACE_CAR_LENGTH;
    }

    private boolean isNullCarName(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (!isCheckNull(carNames.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isCheckNull(String carName) {
        return !carName.equals("");
    }

    private boolean isSmallCarNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (!isCheckRange(carNames.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isCheckRange(String carName) {
        return carName.length() <= RACE_CARNAME_LENGTH;
    }

    private boolean isDiifCarName(List<String> carNames) {
        Set<String> setCarNames = new HashSet<>(carNames);
        return setCarNames.size() == carNames.size();
    }

}
