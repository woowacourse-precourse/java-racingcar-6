package racingcar.service;

import static racingcar.constant.InputConstant.EXECUTION_NUMBER;
import static racingcar.constant.InputConstant.START_MESSAGE;
import static racingcar.util.InputValidation.validateAttemptCount;
import static racingcar.util.InputValidation.validateCommaSeparatedInput;
import static racingcar.util.InputValidation.validateDuplicateValues;
import static racingcar.util.InputValidation.validateEmptyInput;
import static racingcar.util.InputValidation.validateInputLength;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class InputService {
    public static String[] carList;
    public static int attemptCount;

    public static void setInputMessage() {
        System.out.println(START_MESSAGE);
        carList = inputCars();

        System.out.println(EXECUTION_NUMBER);
        attemptCount = getAttemptCount();
    }

    public static String[] inputCars() {
        String cars = Console.readLine();

        validateEmptyInput(cars);
        validateCommaSeparatedInput(cars);
        validateInputLength(cars);
        validateDuplicateValues(cars);

        Car car = new Car(cars);

        String carName = car.getName();

        return createCarList(carName);
    }

    public static String[] createCarList(String cars) {
        String[] carList = cars.split(",");

        return carList;
    }

    public static int getAttemptCount() {
        try {
            int attemptCount = Integer.parseInt(Console.readLine());

            validateAttemptCount(attemptCount);

            return attemptCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
