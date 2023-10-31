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

    public void initGame() {
        playGame();
    }


    private void playGame() {
        int maxMove = 0;
        List<String> carList = inputView.userInputName();
        int count = inputView.userInputCount();
        List<Car> Cars = listUp(carList);
        maxMove = playUntilRound(count, Cars);
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

    private int playRound(List<Car> Cars) {
        int maxMove = 0;
        for (Car car : Cars) {
            if (NumberGenerator.generateNumber() >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
            if (car.getDistance() >= maxMove) {
                maxMove = car.getDistance();
            }
        }
        return maxMove;
    }

    private int playUntilRound(int count, List<Car> Cars) {
        int maxMove = 0;
        for (int i = 0; i < count; i++) {
            maxMove = playRound(Cars);
            OutputView.printRoundResultMessage(Cars);
        }
        return maxMove;
    }

    private void finishGame(List<Car> Cars, int maxMove) {
        OutputView.printGameResultMessage(Cars, maxMove);
    }



}
