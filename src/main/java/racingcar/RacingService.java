package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.common.MessageType;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.common.InputValidator.*;
import static racingcar.common.MessageType.*;
import static racingcar.util.TextUtil.*;

/**
 * @Class : 자동차 경주 서비스 클래스
 */
public class RacingService {

    private static final int MAX_CAR_NAME_SIZE = 5;
    private static final int MIN_MOVE_CONDITIONS = 4;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_ATTEMPTS_COUNT = 1;

    public void racing() {
        List<Car> cars = getAttendCars();
        int attempts = getAttemptsCount();

        printMessageFromType(RESULT);
        raceCars(attempts, cars);
        printWinner(cars);

        Console.close();
    }

    private List<Car> getAttendCars() {
        printMessageFromType(ASK_CAR_NAME);

        String carNames = Console.readLine();
        List<String> carNameList = splitAndTrim(carNames, ",");

        validateNameLength(carNameList, MAX_CAR_NAME_SIZE);
        validateNoDuplicates(carNameList);

        return carNameList.stream()
                .map(c -> new Car(c))
                .collect(Collectors.toList());
    }

    private int getAttemptsCount() {
        printMessageFromType(ASK_ATTEMPTS);

        String inputCount = Console.readLine();
        int attemptsCount = parseInputToInt(inputCount);
        validateMinCount(attemptsCount, MIN_ATTEMPTS_COUNT);

        printMessageFromType(LINE_BREAK);

        return attemptsCount;
    }

    private void raceCars(int attempts, List<Car> cars) {
        for (int i = 0; i < attempts; i++) {
            printRacingResult(cars);
        }
    }

    private void printRacingResult(List<Car> cars) {
        cars.forEach(car -> {
            if (canMoveCar()) {
                car.go();
            }
            printMessage(car.getPositionMessage());
        });
        printMessageFromType(LINE_BREAK);
    }

    private void printWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winnerList = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        printMessage(FINAL_WINNER.getMessage() + joinListWithComma(winnerList));
    }

    private boolean canMoveCar() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MIN_MOVE_CONDITIONS;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMessageFromType(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

}
