package racingcar.validator;

import static racingcar.system.SystemMessage.CAR_NAME_DUPLICATED;
import static racingcar.system.SystemMessage.COMPETITOR_NOT_EXIST;
import static racingcar.system.SystemMessage.INPUT_OUT_OF_RANGE;

import java.util.List;
import racingcar.system.SystemConstant;

public class CarValidator {

    public void validateCarNamesInput(List<String> carNameList) {
        for (String carName : carNameList) {
            validateCarNameOutOfRange(carName);
        }
        validateCarNameDuplicate(carNameList);
        validateIsCompetitorExist(carNameList);
    }

    private void validateCarNameOutOfRange(String carName) {
        if (carName.length() > SystemConstant.CAR_NAME_MAX_RANGE) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateCarNameDuplicate(List<String> carNameList) {
        long distinctCount = carNameList.stream().distinct().count();
        if (distinctCount != carNameList.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED.getMessage());
        }
    }

    private void validateIsCompetitorExist(List<String> carNameList) {
        if (carNameList.size() == 1) {
            throw new IllegalArgumentException(COMPETITOR_NOT_EXIST.getMessage());
        }
    }

}
