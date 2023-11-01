package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.gameInfo.InputCars;
import racingcar.domain.gameInfo.InputManager;
import racingcar.domain.gameInfo.InputProgressCount;
import racingcar.utils.GameMessage;

public class InputView {

    public static InputManager startGameInput() {
        InputCars inputCars = new InputCars(inputCarList());
        InputProgressCount inputProgressCount = new InputProgressCount(inputGameProcessCount());
        System.out.println();
        return new InputManager(inputProgressCount.getProgressCount(), inputCars.getParsedCarList());
    }

    private static String inputCarList() {
        System.out.println(GameMessage.GAME_START_COMMENT.getMessage());
        return Console.readLine();
    }

    private static String inputGameProcessCount() {
        System.out.println(GameMessage.INPUT_TRY_COUNT.getMessage());
        return Console.readLine();
    }

}
