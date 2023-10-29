package racingcar;

import racingcar.domain.Stadium;
import racingcar.utils.GameCountInputManager;
import racingcar.utils.UsernameInputManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String > userNames = UsernameInputManager.getInstance().input();
        Integer moveCount = GameCountInputManager.getInstance().input();
        Stadium stadium= Stadium.of(moveCount, userNames);
        stadium.startRace();
        stadium.confirmWinner();
    }
}
