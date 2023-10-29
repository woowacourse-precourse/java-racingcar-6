package controller;

import view.InputView;
import view.OutputView;
import validator.Validator;
import service.GameService;

public class GameController {
    
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    GameService gameService = new GameService();

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printName();
        String inputName = inputView.inputName();

        List<String> names = gameService.splitName(inputName);
        validator.cheackLengthName(names);

        outputView.printTryNumber();
        String inputTryNumber = inputView.inputTryNumber();

        validator.checkTryNumber();

        //랜덤 수 생성하는 service 호출

    }
}
