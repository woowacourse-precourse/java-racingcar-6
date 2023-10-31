package racingcar;

import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;
    private final RandomNumberGenerator numberGenerator;

    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void run() {
        Cars cars = gameService.getCars();
        int trialCount = gameService.getTrialCount();

        raceCars(cars, trialCount);
        OutputView.printWinners(cars.getWinnerNames());
    }

    private void raceCars(Cars cars, int trialCount) {
        OutputView.printRaceStartMessage();
        for (int i = 0; i < trialCount; i++) {
            OutputView.printRoundResult(cars.race(numberGenerator));
        }
    }

}
