package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    InputView inputView = new InputView();
    GameManager gameManager = new GameManager();
    Cars cars;

    public void gameStart() {
        OutputView.printInputCarNameMessage();
        cars = createCars(inputView.getCarsName());
        OutputView.printInputMovingTryCountMessage();
        runRacing(inputView.getMovingTryCount(), cars);
    }

    public void runRound(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            gameManager.tryMoveCar(cars.getCarInIndex(i));
        }
    }

    public void runRacing(int round, Cars cars) {
        OutputView.printGameRoundResultMessage();
        for (int i = 0; i < round; i++) {
            runRound(cars);
            OutputView.printInfomation(cars.toString());
        }
    }

    public Cars createCars(List<String> carsName) {
        List<Car> carsTempHolder = new ArrayList<>();
        Cars cars;

        for (String carName : carsName) {
            Car car = new Car(carName);
            carsTempHolder.add(car);
        }
        cars = new Cars(carsTempHolder);
        return cars;
    }
}