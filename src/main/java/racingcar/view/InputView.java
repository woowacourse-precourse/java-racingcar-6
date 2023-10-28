package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return getInput();
    }

    private static String getInput() {
        return Console.readLine();
    }

}
