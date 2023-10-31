package racingcar.controller;

import racingcar.DTO.CarDTO;
import racingcar.model.Car;
import racingcar.model.Round;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView INPUT_VIEW;
    private List<Car> cars;
    private int totalRoundCount;

    public GameController(InputView INPUT_VIEW) {
        this.INPUT_VIEW = INPUT_VIEW;
    }

    public void setupGame() {
        List<String> carNames = INPUT_VIEW.inputName();
        List<Car> cars = createCars(carNames);
        setCars(cars);

        int inputNumber = INPUT_VIEW.inputNumber();
        setTotalRoundCount(inputNumber);
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public Round createRound() {
        return new Round();
    }

    public List<List<CarDTO>> play() {
        Round currentRound;

        while (Round.getCurrentRoundCount() < totalRoundCount) {
            currentRound = createRound();
        }
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setTotalRoundCount(int totalRoundCount) {
        this.totalRoundCount = totalRoundCount;
    }
}
