package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String requestUserInputNames() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);

        return Console.readLine();
    }
}
