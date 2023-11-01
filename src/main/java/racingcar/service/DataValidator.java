package racingcar.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.domain.IntegerConstant;
import racingcar.domain.StringConstant;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameInvalidException;
import racingcar.exception.NumberOfCarInvalidException;
import racingcar.exception.TrialNumberInvalidException;

public class DataValidator {

    public void validateCarName(String[] carNames) {
        for (String car : carNames) {
            validateCarName(car);
        }
        validateDuplicatedCars(carNames);
        validateInputCarsIsOne(carNames);
    }

    public void validateTrialNumber(String trialNumber) {
        if (!Pattern.matches(StringConstant.TRIAL_NUMBER_RANGE.getMessage(), trialNumber)) {
            throw new TrialNumberInvalidException();
        }
        if (trialNumber.equals(StringConstant.NONE_TRY.getMessage())) {
            throw new TrialNumberInvalidException();
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > IntegerConstant.CAR_NAME_MAX_LENGTH.getValue()) {
            throw new CarNameInvalidException();
        }
    }

    private void validateDuplicatedCars(String[] carNames) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, carNames);

        if (set.size() != carNames.length) {
            throw new CarNameDuplicateException();
        }
    }

    private void validateInputCarsIsOne(String[] carNames) {
        if (carNames.length == IntegerConstant.MIN_CAR_NUMBER.getValue()) {
            throw new NumberOfCarInvalidException();
        }
    }
}
