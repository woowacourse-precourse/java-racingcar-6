package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingTurnsInputView {

    public static String input() {
        InputMessageView.showRacingTurnsMessage();
        return Console.readLine();
    }
}
