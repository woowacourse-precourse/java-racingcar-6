package racingcar.controller;

import static racingcar.util.StringConverter.stringToInteger;
import static racingcar.util.StringConverter.stringToListByDelimiter;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.TrialCount;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCarsFromInputView();
        TrialCount trial = getTrialCountFromInputView();

        RacingGame racingGame = new RacingGame(cars);
        outputView.printResultMessage();
        
    }

    private Cars getCarsFromInputView() {
        outputView.printRequestCarNameMessage();
        List<String> carNames = stringToListByDelimiter(inputView.inputCarNames());
        return new Cars(carNames);
    }

    private TrialCount getTrialCountFromInputView() {
        outputView.printRequestCountMessage();
        Integer number = stringToInteger(inputView.inputTrialCount());
        return new TrialCount(number);
    }
}
