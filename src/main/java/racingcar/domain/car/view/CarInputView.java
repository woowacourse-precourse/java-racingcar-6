package racingcar.domain.car.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.util.InputMessage.*;

public class CarInputView {

    public static void printGameStart() {
        System.out.println(RECEIVE_CAR_NAME.getMessage());
    }

    public static String receiveUserInput() {
        String userInput = Console.readLine();

        List<String> lists = Arrays.stream(userInput.split(","))
                .toList();

        for (String list : lists) {
            if (list.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return userInput;
    }

    public static void printTryCount() {
        System.out.println(RECEIVE_TRY_COUNT.getMessage());
    }

    public static void printGameEnd() {
        System.out.println();
    }

    public List<String> getCarNames() {
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(","))
                .filter(this::isValidCarNameLength)
                .toList();
    }

    private boolean isValidCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
