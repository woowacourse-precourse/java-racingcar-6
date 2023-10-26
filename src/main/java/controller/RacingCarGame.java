package controller;

import java.util.Arrays;
import view.InputView;
import view.OutputView;

public class RacingCarGame {
    private static InputView inputView;
    private static OutputView outputView;
    public RacingCarGame(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void start() {
        outputView.printStartGame();
        String carName = inputView.inputCarName();
        String[] carNameList = carName.split(",");
        int tryCount = inputView.inputTryCount();
    }
}
