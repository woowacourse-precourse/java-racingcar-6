package racingcar.controller;

import racingcar.service.CarGameService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarGameController {
    OutputView outputView;
    InputView inputView;
    CarGameService carGameService;
    Parser parser;

    public CarGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.carGameService = new CarGameService();
        this.parser = new Parser();
    }

    public void run() {
        outputView.carNameMessage();
        String userInput = inputView.getInput();
        List<String> participant = parser.parseUserInputToList(userInput);

        outputView.numberMessage();
        String numberInput = inputView.getInput();
        int times = parser.ParseInt(numberInput);

        outputView.resultInfoMessage();
        List<String> winner = carGameService.playGame(participant, times);
        outputView.winnerMessage(winner);
    }
}
