package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingTurnsInput {

    public static String input() {
        InputMessageView.inputRacingTurns();
        return Console.readLine();
    }
}
