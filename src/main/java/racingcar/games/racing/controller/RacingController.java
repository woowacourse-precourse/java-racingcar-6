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

    public RacingController() {
        this.racingInputView = new RacingInputView();
        this.racingFormatter = new RacingFormatter();
    }


    @Override
    public void execute() {
        List<String> carNames = getValidatedCarNames();
    }

    private List<String> getValidatedCarNames() {
        String input = racingInputView.readCarNames();
        return racingFormatter.reformatCarNames(input);
    }
}
