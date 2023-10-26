package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService racingGameService;
    

    public RacingGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.racingGameService = new RacingGameService();
    }

    public void run() {
        handleCarNameInput();
    }
    
    public void handleCarNameInput() {
        outputView.printCarNameInputMessage();
        String carNames = inputView.carNameInput();
        racingGameService.addCars(carNames);
    }
    
    
}
