package racingcar.domain.game;

import static racingcar.constant.CommonConstant.ONE_BLANK_LINE;
import static racingcar.constant.GameConstant.INITIAL_START_ROUND;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.dto.Car;
import racingcar.dto.Round;
import racingcar.view.OutputView;

public class Game {
    private static final CarInfo carInfo = CarInfo.getInstance();
    public static Integer totalRounds = 0;

    public List<Car> playGame() {
        GameRound gameRound = new GameRound(new Round(INITIAL_START_ROUND));

        while (gameRound.getCurrentRound() < totalRounds) {
            gameRound.passRound();
            gameRound.startRound();
            OutputView.printBlankLine(ONE_BLANK_LINE);
        }

        GameWinnerFinder gameWinnerFinder = new GameWinnerFinder(carInfo.getAllCarInfo());

        return gameWinnerFinder.findWinner();
    }

    public void saveTotalRound(Integer round) {
        totalRounds = round;
    }
}
