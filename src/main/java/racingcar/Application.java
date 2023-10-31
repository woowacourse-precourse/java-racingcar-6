package racingcar;

import racingcar.domain.Stadium;
import racingcar.utils.input.GameCountInputManager;
import racingcar.utils.input.UsernameInputManager;
import racingcar.utils.output.SystemOutputManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        SystemOutputManager.NAME_INPUT.output();
        List<String> userNames = UsernameInputManager.getInstance().input();

        SystemOutputManager.GAME_COUNT_INPUT.output();
        Integer moveCount = GameCountInputManager.getInstance().input();

        Stadium stadium = Stadium.of(moveCount, userNames);
        stadium.startRace();
        stadium.concludeResult();
    }
}
