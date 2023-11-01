package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameView racingGameView;
    private final RacingGameLogic racingGameLogic;

    public RacingGame() {
        this.racingGameView = new RacingGameView();
        this.racingGameLogic = new RacingGameLogic();
    }

    public void start() {
        List<RacingCar> racingCars = new ArrayList<>();
        List<String> carNames = racingGameView.inputCarNames();
        int gameRounds = racingGameView.inputGameRounds();

        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
        playRounds(gameRounds, racingCars);
        racingGameView.printWinners(racingGameLogic.getWinners(racingCars));
    }

    private void playRounds(int gameRounds, List<RacingCar> racingCars) {
        racingGameView.printResultMessage();
        for (int round = 0; round < gameRounds; round++) {
            moveCars(racingCars);
            racingGameView.printRoundResult(racingCars);
        }
    }

    private void moveCars(List<RacingCar> racingCars) {
        racingCars.forEach(RacingCar::move);
    }
}
