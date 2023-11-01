package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ConsoleMessage;
import racingcar.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static List<String> inputCar() {
        System.out.println(ConsoleMessage.GAME_START.getMessage());
        String cars = Console.readLine();

        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputTrial() {
        System.out.println(ConsoleMessage.INPUT_TRIAL.getMessage());
        String trial = Console.readLine();

        validateTrialIsNumber(trial);
        validateTrialZero(trial);

        return Integer.parseInt(trial);
    }

    private static void validateTrialIsNumber(String trial) {
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    private static void validateTrialZero(String trial) {
        if (Integer.parseInt(trial) < 1) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ZERO.getMessage());
        }
    }
}
