package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.MessageConstants;

public class GameView {

    public String inputCarName() {
        System.out.println(MessageConstants.GAME_START_GUIDE);
        return Console.readLine();
    }

    public String inputTryCount() {
        System.out.println(MessageConstants.TRY_COUNT_GUIDE);
        return Console.readLine();
    }

    public void printGameLog(StringBuilder gameLog) {
        System.out.println(gameLog);
    }
}
