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
    private final RacingFormatter racingFormatter;
    private final RacingService racingService;

    public RacingController() {
        this.racingInputView = new RacingInputView();
        this.racingFormatter = new RacingFormatter();
        this.racingService = new RacingService(new DefaultProcessor());
    }


    @Override
    public void execute() {
        List<String> carNames = getValidatedCarNames();
        racingService.registerCars(carNames);
        int attemptNumber = getValidatedAttemptNumber();
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
