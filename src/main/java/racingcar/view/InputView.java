package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUIRE_CAR_NAMES_MESSAGE = "";

    public String readCarNames(){
        System.out.println(REQUIRE_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
}
