package racingcar;

import static racingcar.message.AlarmMessage.BEFORE_GAME_PROGRESS_MESSAGE;
import static racingcar.message.AlarmMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.message.AlarmMessage.MOVE_COUNT_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameInput;
import racingcar.domain.RacingCarGameOutput;
import racingcar.dto.RacingCar;

public class RacingCarGameLauncher {
    private RacingCarGame racingCarGame;

    public void launch() {
        System.out.println(CAR_NAME_INPUT_MESSAGE.getMessage());
        List<RacingCar> racingCarList = RacingCarGameInput.readCarNames();

        System.out.println(MOVE_COUNT_INPUT_MESSAGE.getMessage());
        int moveCount = RacingCarGameInput.readMoveCount();

        racingCarGame = new RacingCarGame(racingCarList, moveCount);

        System.out.println(BEFORE_GAME_PROGRESS_MESSAGE.getMessage());
        racingCarGame.run(() -> Randoms.pickNumberInRange(0, 9));

        RacingCarGameOutput.printWinnersMessage(racingCarGame.getWinners());
    }
}
