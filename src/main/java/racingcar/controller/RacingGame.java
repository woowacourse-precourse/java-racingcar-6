package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.NumberGenerator;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start(){
        outputView.printRacingCarNameInputMessage();
        String[] carNames = inputView.readRacingCarName();

        outputView.printNumberOfTryInputMessage();
        int numberOfTry = inputView.readNumberOfTry();
    }
}
