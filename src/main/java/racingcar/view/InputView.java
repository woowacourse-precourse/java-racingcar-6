package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestCarNameFromUser() {
        return Console.readLine();
    }

    public String requestRacingRoundCountFromUser() {
        return Console.readLine();
    }
}
