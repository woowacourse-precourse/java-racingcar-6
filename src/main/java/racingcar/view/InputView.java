package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public final String inputCarNamesToRace() {
        System.out.println(OutputMessage.REQUEST_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public final String inputNumberOfRace() {
        System.out.println(OutputMessage.REQUEST_NUMBER_OF_TRY.getMessage());
        return Console.readLine();
    }
}
