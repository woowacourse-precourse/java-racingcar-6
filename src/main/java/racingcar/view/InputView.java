package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUIRE_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUIRE_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(REQUIRE_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String readTryCount() {
        System.out.println(REQUIRE_TRY_COUNT_MESSAGE);
        return Console.readLine();
    }
}
