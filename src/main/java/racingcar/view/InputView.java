package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.gameInfo.InputManager;
import racingcar.domain.gameInfo.InputCars;
import racingcar.domain.gameInfo.InputTryCount;

public class InputView {
    private final static String GAME_START_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_COUNT = "시도할 횟수는 몇회인가요?";

    public static InputManager startGameInput() {
        InputCars inputCars = new InputCars(inputCarList());
        InputTryCount inputTryCount = new InputTryCount(inputGameProcessCount());
        System.out.println();
        return new InputManager(inputTryCount.getInputTryCount(), inputCars.getParsedCarList());
    }

    private static String inputCarList(){
        System.out.println(GAME_START_COMMENT);
        return Console.readLine();
    }

    private static String inputGameProcessCount() {
        System.out.println(INPUT_TRY_COUNT);
        return Console.readLine();
    }

}
