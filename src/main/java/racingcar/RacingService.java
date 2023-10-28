package racingcar;

import camp.nextstep.edu.missionutils.Console;
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

    public void racing() {
        List<Car> cars = getAttendCars();

        int attempts = getAttemptsCount();

        int currentAttempts = 0;
        println(RESULT);
        while (currentAttempts < attempts) {
            printRacingResult(cars);
            println(LINE_BREAK);
            currentAttempts++;
        }

        printWinner();
    }

    private List<Car> getAttendCars() {
        println(ASK_CAR_NAME);

        String carNames = Console.readLine();
        List<String> carNameList = splitAndTrim(carNames, ",");

        validationCarNames(carNameList);

        return carNameList.stream()
                .map(c -> new Car(c))
                .collect(Collectors.toList());
    }

    public void validationCarNames(List<String> carNameList) {
        if (hasOverLengthCarNames(carNameList)) {
            throw new IllegalArgumentException("Car names exceed the maximum length.");
        }
        if (hasDuplicates(carNameList)) {
            throw new IllegalArgumentException("Car names contains duplicates.");
        }
    }

    private int getAttemptsCount() {
        println(ASK_ATTEMPTS);
        String inputCount = Console.readLine();
        int attemptsCount = convertToAttemptsCount(inputCount);
        println(LINE_BREAK);

        return attemptsCount;
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

        if(attemptsCount < 1) {
            throw new IllegalArgumentException("Number of attempts must be a non-zero positive number.");
        }

        return attemptsCount;
    }

    private void printRacingResult(List<Car> cars) {
    }


    private void printWinner() {
    }

    private static void println(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    private static boolean hasOverLengthCarNames(List<String> carNameList) {
        return carNameList.stream().anyMatch(c -> isOverLength(c, maxCarNameSize));
    }

}
