package racingcar.converter;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.TrialCount;
import racingcar.util.StringUtils;
import racingcar.validator.InputValidator;

public class InputConverter {
    private final InputValidator inputValidator;

    public InputConverter(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Cars toCars(String input) {
        inputValidator.validateInputFormat(input);
        inputValidator.validateNonEmpty(input);

        List<Car> cars = StringUtils.splitStringToList(input).stream()
                .map(CarName::from)
                .map(Car::from)
                .toList();

        return Cars.from(cars);
    }

    public TrialCount toTrialCount(String input) {
        inputValidator.validateNumericString(input);
        int trialCount = Integer.parseInt(input);
        return TrialCount.from(trialCount);
    }
}
