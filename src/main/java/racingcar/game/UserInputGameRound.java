package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant;

public class UserInputGameRound {
    public static int getGameRound() {
        String inputRound = inputGameRound();
        return processInput(inputRound);
    }

    private static String inputGameRound() {
        System.out.println(Constant.COUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        return input.trim();
    }

    public static int processInput(String round) {
        ValidateGame.validator(round);
        return Integer.parseInt(round);
    }
}