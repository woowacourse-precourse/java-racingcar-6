package racingcar;

import racingcar.Car;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.CommandLine.inputln;

public class InputArgumentsHandler {

    public List<Car> inputCars() {
        String input = inputln("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        validateName(input);
        return mapToCarList(input);
    }

    public int inputRoundNumbers() {
        String attempt = inputln("시도할 회수는 몇 회 인가요?");
        validateAttempt(attempt);
        return Integer.parseInt(attempt);
    }

    private List<Car> mapToCarList(String input) {
        return Arrays
                .stream(input.split(","))
                .map(carName -> new Car(carName.trim(), 0))
                .collect(toList());
    }

    private void validateName(String input) {
        if (input.isBlank() || carNameLengthIsOverFive(input)) {
            throwIllegalArgumentException();
        }
    }

    private boolean carNameLengthIsOverFive(String input) {
        String[] carList = input.split(",");
        for (String car : carList) {
            if (car.length() > 5) {
                return true;
            }
        }
        return false;
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    private void validateAttempt(String attempt) {
        if (attempt.isBlank()) {
            throwIllegalArgumentException();
        }
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException();
        }
    }
}
