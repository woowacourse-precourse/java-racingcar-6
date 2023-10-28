package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.MessageConstants;

public class GameView {

    public String inputCarName() {
        System.out.println(MessageConstants.GAME_START_GUIDE);
        return Console.readLine();
    }
}
