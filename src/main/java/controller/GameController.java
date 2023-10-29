package controller;

import view.InputView;
import view.OutputView;
import validator.Validator;

public class GameController {
    
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();


    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printName();
        String inputName = inputView.inputName();

        //inputName을 List<String>으로 변환하는 Service
        validator.cheackLengthName();

        outputView.printTryNumber();
        String inputTryNumber = inputView.inputTryNumber();

        validator.checkTryNumber();

        //랜덤 수 생성하는 service 호출
        
    }
}
