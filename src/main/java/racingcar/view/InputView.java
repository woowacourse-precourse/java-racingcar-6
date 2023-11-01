package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MSG_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static String enterRacingCarName() {
        System.out.println(MSG_RACING_CAR_NAME);
        return getInput();
    }

    private static String getInput() {
        return Console.readLine();
    }
}
