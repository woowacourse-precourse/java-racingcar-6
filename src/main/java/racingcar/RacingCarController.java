package racingcar;

import java.util.Map;

public class RacingCarController {

    public void run() {
        gameStart();
    }

    private void gameStart() {
        Map<String, String> carNamesMap = InputView.CarNames();
        int attemptNumber = InputView.AttemptNumber();
        OutputView.printEnter();
        OutputView.printGameResult();
        GameProgress.racing(carNamesMap, attemptNumber);
    }
}
