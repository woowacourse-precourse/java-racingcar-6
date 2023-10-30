package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void initGame() {
        playGame();
    }


    private void playGame() {
        List<String> carList = inputView.userInputName();
        int count = inputView.userInputCount();
        List<Car> Cars = listUp(carList);
        playUntilRound(count);
    }

    private List<Car> listUp (List<String> carList) {
        List<Car> Cars = new ArrayList<>();
        for (String name : carList) {
            Car newCar = new Car(name, 0);
            Cars.add(newCar);
        }
        return Cars;
    }

    private void playUntilRound(int count) {

    }




}
