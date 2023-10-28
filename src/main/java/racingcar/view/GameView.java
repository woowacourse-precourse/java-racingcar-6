package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.MessageConstants;
import racingcar.validators.InputCarNameValidator;

public class GameView {

    public String inputCarName() {
        System.out.println(MessageConstants.GAME_START_GUIDE);
        String carNames = Console.readLine();
        InputCarNameValidator.validateCarName(carNames);
        return carNames;
    }

    public String inputTryCount() {
        System.out.println(MessageConstants.TRY_COUNT_GUIDE);
        return Console.readLine();
    }

    public void printGameLog(StringBuilder gameLog) {
        System.out.println(gameLog);
    }
}
