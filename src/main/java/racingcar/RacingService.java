package racingcar;

import camp.nextstep.edu.missionutils.Console;
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

        println(ASK_ATTEMPTS);
        int attempts = getAttemptsCount();
        println(LINE_BREAK);

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
        return 0;
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
