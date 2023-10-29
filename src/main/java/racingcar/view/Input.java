package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ConsoleMessage;
import racingcar.model.ErrorManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public List<String> inputCar(){
        System.out.println(ConsoleMessage.GAME_START.getMessage());
        String cars = Console.readLine();

        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int inputTrial(){
        String trial = Console.readLine();
        ErrorManager.validateTrialIsNumber(trial);
        ErrorManager.validateTrialZero(trial);

        return Integer.parseInt(trial);
    }
}
