package racingcar.controller;

import java.util.List;
import racingcar.service.CarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarGameService carGameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carGameService = new CarGameService();
    }

    public void start() {
        initGame();
        List<String> carNames = carGameService.extractSeperator(inputView.inputCarName());



    }

    private void initGame() {
        outputView.printInitGame();
    }
}
