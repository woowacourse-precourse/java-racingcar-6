package controller;

import java.util.ArrayList;
import java.util.Arrays;
import model.Car;
import util.CarNameValidation;
import util.TryCountValidation;
import view.InputView;
import view.OutputView;

public class RacingCarGame {
    static ArrayList<Car> carNameList;
    static int tryCount;
    private static InputView inputView;
    private static OutputView outputView;


    public RacingCarGame() {
        inputView = new InputView();
        outputView = new OutputView();
        carNameList = new ArrayList<>();
    }

    public void start() {
        outputView.printStartGame();
        setCarNames(inputView.inputCarName());
        CarNameValidation.checkCarNameValidation(carNameList);

        setTryCount(inputView.inputTryCount());
        TryCountValidation.checkTryCountValidation(tryCount);

    }

    private void setCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNameList.add(new Car(carNames[i]));
        }
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
