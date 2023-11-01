package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int maxMove = 0;
    public void initGame() {
        playGame();
    }


    private void playGame() {
        maxMove = 0;
        List<String> carList = inputView.userInputName();
        int count = inputView.userInputCount();
        List<Car> Cars = listUp(carList);
        playUntilRound(count, Cars);
        finishGame(Cars, maxMove);
    }

    private List<Car> listUp (List<String> carList) {
        List<Car> Cars = new ArrayList<>();
        for (String name : carList) {
            Car newCar = new Car(name, 0);
            Cars.add(newCar);
        }
        return Cars;
    }

    private void playRound(List<Car> Cars) {
        for (Car car : Cars) {
            if (NumberGenerator.generateNumber() >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
            if (car.getDistance() >= maxMove) {
                maxMove = car.getDistance();
            }
        }
    }

    private void playUntilRound(int count, List<Car> Cars) {

        for (int i = 0; i < count; i++) {
            playRound(Cars);
            OutputView.printRoundResultMessage(Cars);
        }
    }

    private void finishGame(List<Car> Cars, int maxMove) {
        OutputView.printGameResultMessage(Cars, maxMove);
    }



}
