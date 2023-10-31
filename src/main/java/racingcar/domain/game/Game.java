package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.dto.Car;
import racingcar.dto.Round;
import racingcar.view.OutputView;

public class Game {
    private final int START_NUMBER = 0;
    private final int BLANK_LINES_NUMBER = 1;
    private static final CarInfo carInfo = CarInfo.getInstance();
    public static Integer totalRounds = 0;

    public List<Car> playGame() {
        GameRound gameRound = new GameRound(new Round(START_NUMBER));

        while (gameRound.getCurrentRound() < totalRounds) {
            gameRound.passRound();
            gameRound.startRound();
            OutputView.printBlankLine(BLANK_LINES_NUMBER);
        }

        GameWinnerFinder gameWinnerFinder = new GameWinnerFinder(carInfo.getAllCarInfo());

        return gameWinnerFinder.findWinner();
    }

    public void saveTotalRound(Integer round) {
        totalRounds = round;
    }
}
