package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputManager;
import racingcar.validation.InputGameInfoValidate;

public class InputView {
    private final static String GAME_START_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_COUNT = "시도할 횟수는 몇회인가요?";

    public static InputManager startGameInput() {
        System.out.println(GAME_START_COMMENT);
        String carList = inputCarList();
        System.out.println(INPUT_TRY_COUNT);
        int tryCount = inputGameProcessCount();
        InputGameInfoValidate.gameProcessCountValidate(tryCount);
        System.out.println();
        return new InputManager(tryCount, carList);
    }

    private static int inputGameProcessCount() {
        return Integer.parseInt(Console.readLine());
    }

    private static String inputCarList() {
        return Console.readLine();
    }

}
