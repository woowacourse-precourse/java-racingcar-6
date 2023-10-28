package racingcar.domain.car.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.util.InputMessage;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.util.InputMessage.*;

public class InputView {

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
}
