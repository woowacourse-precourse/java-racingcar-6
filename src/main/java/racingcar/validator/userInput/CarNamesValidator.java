package racingcar.validator.userInput;

import java.util.List;
import racingcar.constant.RacingGameConstants;
import racingcar.exception.car.carName.HasSpaceException;
import racingcar.exception.car.carName.LengthException;
import racingcar.exception.cars.DuplicateException;
import racingcar.utils.Parser;

public class CarNamesValidator extends UserInputValidator {
    private static final CarNamesValidator carNamesValidator = new CarNamesValidator();

    private CarNamesValidator() {
    }

    public static CarNamesValidator getInstance() {
        return carNamesValidator;
    }

    @Override
    public void validate(String carNames) {
        List<String> carNameList = Parser.parseWithComma(carNames);
        carNameList.forEach(this::validateCarName);
        validateDuplicateName(carNameList);
    }

    public void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameHasNoSpace(carName);
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() < RacingGameConstants.CAR_NAME_LENGTH_MIN
                || carName.length() > RacingGameConstants.CAR_NAME_LENGTH_MAX) {
            throw new LengthException();
        }
    }

    public void validateCarNameHasNoSpace(String carName) {
        if (carName.contains(" ") || carName.contains("\t")) {
            throw new HasSpaceException();
        }
    }

    private void validateDuplicateName(List<String> carNameList) {
        if (carNameList.stream()
                .distinct()
                .count() != carNameList.size()) {
            throw new DuplicateException();
        }
    }
}
