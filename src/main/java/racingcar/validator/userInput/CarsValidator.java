package racingcar.validator.userInput;

import java.util.List;
import racingcar.constant.RacingGameConstants;
import racingcar.exception.car.name.HasBlankException;
import racingcar.exception.car.name.LengthException;
import racingcar.exception.cars.DuplicateException;
import racingcar.utils.Parser;

public class CarsValidator extends UserInputValidator {
    private static CarsValidator carsValidator = new CarsValidator();

    private CarsValidator() {
    }

    public static CarsValidator getInstance() {
        return carsValidator;
    }

    @Override
    public void validate(String carNames) {
        List<String> carNameList = Parser.parseWithComma(carNames);
        carNameList.forEach(this::validateCarName);
        validateDuplicateName(carNameList);
    }

    public void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameNoBlanks(carName);
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() < RacingGameConstants.CAR_NAME_LENGTH_MIN
                || carName.length() > RacingGameConstants.CAR_NAME_LENGTH_MAX) {
            throw new LengthException();
        }
    }

    public void validateCarNameNoBlanks(String carName) {
        if (carName.contains(" ") || carName.contains("\t") || carName.contains("\n")) {
            throw new HasBlankException();
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
