package controller;

import java.util.ArrayList;
import java.util.Arrays;
import model.Car;
import model.TryCount;
import org.junit.platform.commons.function.Try;
import util.CarNameValidation;
import util.TryCountValidation;
import view.InputView;
import view.OutputView;

public class RacingCarGame {
    static ArrayList<Car> carNameList;
    static TryCount tryCount;
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
        setTryCount(inputView.inputTryCount());

    }

    private void setCarNames(String[] carNames) {
        CarNameValidation.checkCarNameValidation(carNames);
        for (int i = 0; i < carNames.length; i++) {
            carNameList.add(new Car(carNames[i]));
        }
    }

    private void setTryCount(String tryCount) {
        TryCountValidation.checkTryCountValidation(tryCount);
        this.tryCount = new TryCount(Integer.parseInt(tryCount));
    }


}
