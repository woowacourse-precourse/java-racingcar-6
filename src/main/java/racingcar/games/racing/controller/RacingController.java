package racingcar.games.racing.controller;

import java.util.List;
import racingcar.Game;
import racingcar.games.racing.service.RacingService;
import racingcar.games.racing.util.DefaultProcessor;
import racingcar.games.racing.util.RacingFormatter;
import racingcar.games.racing.view.RacingInputView;
import racingcar.games.racing.view.RacingOutputView;

public class RacingController implements Game {

    private final RacingInputView racingInputView;
    private final RacingOutputView racingOutputView;
    private final RacingFormatter racingFormatter;
    private final RacingService racingService;

    public RacingController() {
        this.racingInputView = new RacingInputView();
        this.racingOutputView = new RacingOutputView();
        this.racingFormatter = new RacingFormatter();
        this.racingService = new RacingService(new DefaultProcessor());
    }


    @Override
    public void execute() {
        List<String> carNames = getValidatedCarNames();
        racingService.registerCars(carNames);
        int attemptNumber = getValidatedAttemptNumber();
        raceWhile(attemptNumber);
        racingOutputView.printWinners(racingService.makeWinnerList());
    }

    private void raceWhile(int attemptNumber) {
        racingOutputView.printMessage("실행 결과");
        for (int i = 0; i < attemptNumber; i++) {
            racingService.move();
            List<String> results = racingService.makePlayResult();
            racingOutputView.printPlayResult(results);
        }
    }

    private List<String> getValidatedCarNames() {
        String input = racingInputView.readCarNames();
        return racingFormatter.reformatCarNames(input);
    }

    private int getValidatedAttemptNumber() {
        String input = racingInputView.readAttempt();
        return racingFormatter.reformatAttemptNumber(input);
    }
}
