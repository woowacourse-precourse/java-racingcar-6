package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.utils.StringParser;
import racingcar.model.Car;
import racingcar.model.CarService;
import racingcar.view.GameView;

public class GameController {
    private final CarService model;
    private final GameView view;
    private final StringParser stringParser = new StringParser();

    public GameController(CarService model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        List<String> carNames;
        List<Car> cars;
        int trialNumber;
        List<String> winnerNames;

        carNames = stringParser.splitCarNames(view.inputCarName());
        cars = createCarObject(carNames);
        model.saveAllCars(cars);

        trialNumber = stringParser.toInteger(view.inputTrialNumber());
        gameStart(trialNumber);

        winnerNames = model.getCarNameWithLongestDistance();
        view.printWinner(winnerNames);
    }

    private List<Car> createCarObject(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }

    private void gameStart(int trialNumber) {
        List<Car> cars = model.getAllCars();

        view.printResultMessage();
        for (int i = 0; i < trialNumber; i++) {
            model.FowardCars();
            for(Car car : cars){
                view.printCurrentStatus(car.getName(), car.getCurrentLocation());
            }
            view.printEnter();
        }

    }
}
