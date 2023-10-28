package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.util.StringUtils;
import racingcar.model.Car;
import racingcar.type.MessageType;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.type.MessageType.*;
import static racingcar.util.TextUtil.*;

/**
 * @Class : 자동차 경주 서비스 클래스
 */
public class RacingService {

    private static final int maxCarNameSize = 5;
    private static final int minMoveConditions = 4;
    private static final int minRandomValue = 0;
    private static final int maxRandomValue = 9;

    public void racing() {
        List<Car> cars = getAttendCars();

        int attempts = getAttemptsCount();

        Console.close();

        printMessageFromType(RESULT);

        int currentAttempts = 0;
        while (currentAttempts < attempts) {
            printRacingResult(cars);
            currentAttempts++;
        }

        printWinner(cars);
    }

    private List<Car> getAttendCars() {
        printMessageFromType(ASK_CAR_NAME);

        String carNames = Console.readLine();
        List<String> carNameList = splitAndTrim(carNames, ",");

        validationCarNames(carNameList);

        return carNameList.stream()
                .map(c -> new Car(c))
                .collect(Collectors.toList());
    }

    private int getAttemptsCount() {
        printMessageFromType(ASK_ATTEMPTS);
        String inputCount = Console.readLine();
        int attemptsCount = convertToAttemptsCount(inputCount);
        printMessageFromType(LINE_BREAK);
        return attemptsCount;
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

    public void validationCarNames(List<String> carNameList) {
        if (hasOverLengthCarNames(carNameList)) {
            throw new IllegalArgumentException("Car names exceed the maximum length.");
        }
        if (hasDuplicates(carNameList)) {
            throw new IllegalArgumentException("Car names contains duplicates.");
        }
    }

    public int convertToAttemptsCount(String inputCount) {
        if (StringUtils.isBlank(inputCount)) {
            throw new IllegalArgumentException("Number of attempts cannot be empty or only whitespace.");
        }

        int attemptsCount;
        try {
            attemptsCount = Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid numerical format.", e);
        }

        if (attemptsCount < 1) {
            throw new IllegalArgumentException("Number of attempts must be a non-zero positive number.");
        }

        return attemptsCount;
    }

    private boolean canMoveCar() {
        return Randoms.pickNumberInRange(minRandomValue, maxRandomValue) >= minMoveConditions;
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

    private static boolean hasOverLengthCarNames(List<String> carNameList) {
        return carNameList.stream().anyMatch(c -> isOverLength(c, maxCarNameSize));
    }

}
