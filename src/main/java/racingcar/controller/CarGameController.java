package racingcar.controller;

import racingcar.service.CarGameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarGameController {
    OutputView outputView;
    InputView inputView;
    CarGameService carGameService;
    Parser parser;
    Validator validator;

    public CarGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.carGameService = new CarGameService();
        this.parser = new Parser();
        this.validator = new Validator();
    }

    public void run() {
        outputView.carNameMessage();
        String userInput = inputView.getInput();
        List<String> participant = parser.parseUserInputToList(userInput);
        validator.validName(participant);

        outputView.numberMessage();
        String numberInput = inputView.getInput();
        validator.validParseInt(numberInput);
        int times = parser.ParseInt(numberInput);

        outputView.resultInfoMessage();
        List<String> winner = carGameService.playGame(participant, times);
        outputView.winnerMessage(winner);
    }
}
