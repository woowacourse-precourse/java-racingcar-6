package racingcar;

import java.util.Map;

public class RacingCarController {

    public void run() {
        gameStart();
    }

    private void gameStart() {
        Map<String, String> racingCars = InputView.CarNames();
        int attemptNumber = InputView.AttemptNumber();
        OutputView.printEnter();
        OutputView.printGameResult();
        GameProgress.racing(racingCars, attemptNumber);
        GameResult.getWinner(racingCars);
    }
}
