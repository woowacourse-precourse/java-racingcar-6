package racingcar.converter;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.game.car.Car;
import racingcar.domain.game.car.CarName;
import racingcar.domain.game.car.Cars;
import racingcar.domain.game.car.TrialCount;
import racingcar.validator.InputValidator;

public class InputConverter {
    private final InputValidator inputValidator;

    public InputConverter(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Cars toCars(String input) {

        inputValidator.validateInputFormat(input);
        inputValidator.validateNonEmpty(input);
        inputValidator.validateInputCarCount(input);

        List<Car> cars = Arrays.stream(input.split(","))
                .map(CarName::from)
                .map(Car::from)
                .toList();

        return Cars.from(cars);
    }

    public int toTrial(String input) {
        inputValidator.validateNumericString(input);
        return Integer.parseInt(input);
    }

    public TrialCount converStringToTrialCount(String input) {
        int trialCount = Integer.parseInt(input);
        return TrialCount.from(trialCount);
    }
}
