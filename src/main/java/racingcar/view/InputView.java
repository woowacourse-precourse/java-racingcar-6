package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.PlayerValidation;
import racingcar.validation.TryNumberValidation;

public class InputView {

    PlayerValidation inputValidation;
    public static String [] getPlayerInput() {
        String input = Console.readLine();
        String [] players = splitWithComma(input);
        return players;
    }

    public static int getTryNumberInput() {
        String input = Console.readLine();
        new TryNumberValidation(input);
        return Integer.parseInt(input);
    }

    private static String [] splitWithComma(String input) {
        String[] splits = input.split(",");
        for (String split : splits) {
            new PlayerValidation(split);
        }
        return splits;
    }
}
