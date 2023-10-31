package racingcar.controller;

import static racingcar.view.GameView.inputCarName;
import static racingcar.view.GameView.inputTrialNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.controller.utils.Parser;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game model;
    private GameView view;
    private final Parser parser = new Parser();

    public GameController(Game model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        List<String> carNames = parser.splitCarNames(inputCarName());
        System.out.println(carNames);

        List<Car> cars = createCarObject(carNames);
        model.setCars(cars);

        int trialNumber = parser.parseInteger(inputTrialNumber());
        System.out.println(trialNumber);

        gameStart(trialNumber, cars);
    }

    private List<Car> createCarObject(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }

    private void gameStart(int trialNumber, List<Car> cars) {
        for (int i = 0; i < trialNumber; i++) {
            for (Car car : cars){
                System.out.println(car.getName());
            }
        }
    }

}
