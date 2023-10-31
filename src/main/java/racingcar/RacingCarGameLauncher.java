package racingcar;

import java.util.List;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGame;
import racingcar.utils.RacingCarGameInput;
import racingcar.utils.RacingCarGameOutput;

public class RacingCarGameLauncher {
    private RacingCarGame racingCarGame;

    public void launch() {
        RacingCarGameOutput.printCarNameInputMessage(RacingCarGameOutput.CAR_NAME_INPUT_MESSAGE);
        List<RacingCar> racingCarList = RacingCarGameInput.readCarNames();
        RacingCarGameOutput.printMoveCountInputMessage(RacingCarGameOutput.MOVE_COUNT_INPUT_MESSAGE);
        int moveCount = RacingCarGameInput.readMoveCount();
        racingCarGame = new RacingCarGame(racingCarList, moveCount);
        RacingCarGameOutput.printBeforeGameProgress(RacingCarGameOutput.BEFORE_GAME_MESSAGE);
        racingCarGame.run(() -> Randoms.pickNumberInRange(0, 9));
        RacingCarGameOutput.printWinnersMessage(racingCarGame.getWinners());
    }
}
