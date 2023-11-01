package racingcar.common.util;

import racingcar.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.common.message.ErrorConstant.NOT_INTEGER_ERROR_MESSAGE;
import static racingcar.common.message.GameConstant.INPUT_CAR_NAMES_MESSAGE;
import static racingcar.common.message.GameConstant.INPUT_TRY_NUMBER_MESSAGE;

public class InputUtil {
    private final Validator validator;

    public InputUtil(Validator validator) {
        this.validator = validator;
    }

    public List<Car> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return inputCarName();
    }

    private List<Car> inputCarName() {
        String carNameString = readLine();
        List<Car> cars = Arrays.asList(carNameString.split(",")).stream()
                .filter(s -> validator.verifyCarNameLength(s))
                .map(s -> new Car(s))
                .collect(Collectors.toList());
        return cars;
    }

    public int inputAttemptNumber() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
        String numberString = readLine();
        if (!validator.isInt(numberString)) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
        return Integer.parseInt(numberString);
    }
}
