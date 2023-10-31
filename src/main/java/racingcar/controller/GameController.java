package racingcar.controller;

import static racingcar.view.GameView.inputCarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game model;
    private GameView view;

    public GameController(Game model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        String input = inputCarName();
        List<String> carNames = splitCarNames(input);
        System.out.println(carNames);

        List<Car> cars = createCarObject(carNames);
        model.setCars(cars);
    }

    private List<String> splitCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private List<Car> createCarObject(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }
}
