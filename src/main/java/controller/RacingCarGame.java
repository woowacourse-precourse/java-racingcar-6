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
    private static InputView inputView;
    private static OutputView outputView;

    public RacingCarGame() {
        inputView = new InputView();
        outputView = new OutputView();
        carNameList = new ArrayList<>();
    }

    public void start() {
        outputView.printStartGame();
        inputCarNames(inputView.inputCarName());
        CarNameValidation.checkCarNameValidation(carNameList);

        int tryCount = inputView.inputTryCount();
//        System.out.println(Arrays.toString(carNameList));

    }

    private void inputCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNameList.add(new Car(carNames[i]));
        }
    }
}
