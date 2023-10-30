package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.CarName;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> winner = new ArrayList<>();
    private CalculatingScore scoreBoard = new CalculatingScore();
    private PrizingWinners prizingWinners = new PrizingWinners();
    private MovingCars movingCars = new MovingCars();
    private CarName carName = new CarName();
    public void play() {
        splitCars(inputCarName());
        movingCars.start(carList);
        scoreBoard.result(carList, winner);
        prizingWinners.select(winner);
    }

    private void splitCars(String carNames) {
        String[] cars = carNames.split(",");

        for (String name : cars) {
            Car car = new Car(name, "");
            carList.add(car);
        }
    }

    private String inputCarName() {
        return carName.input();
    }
}
