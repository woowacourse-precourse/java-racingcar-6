package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.utils.CarNameValidator;
import racingcar.controller.utils.StringParser;
import racingcar.controller.utils.TrialNumberValidator;
import racingcar.model.Car;
import racingcar.model.CarCollection;
import racingcar.model.CarService;
import racingcar.view.GameView;

public class GameController {

    private final CarService model;
    private final GameView view;
    private final StringParser stringParser = new StringParser();
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TrialNumberValidator trialNumberValidator = new TrialNumberValidator();

    public GameController(CarService model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        List<String> carNames = getCarNames(view.inputCarName());
        CarCollection cars = createCarCollection(carNames);
        model.saveAllCars(cars);

        int trialNumber = getTrialNumber(view.inputTrialNumber());
        gameStart(trialNumber);

        List<String> winnerNames = model.getCarNameHasLongestDistance();
        view.printWinner(winnerNames);
    }

    public List<String> getCarNames(String input) {
        carNameValidator.validateCarNameInput(input);
        return stringParser.splitCarNames(input);
    }

    public CarCollection createCarCollection(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
        return new CarCollection(cars);
    }

    public int getTrialNumber(String input) {
        trialNumberValidator.validateTrialNumberInput(input);
        return Integer.parseInt(input);
    }

    public void gameStart(int trialNumber) {
        CarCollection cars = model.getAllCars();

        view.printResultMessage();
        for (int i = 0; i < trialNumber; i++) {
            model.moveCars();
            printEachCarCurrentStatus(cars);
            view.printEnter();
        }
    }

    public void printEachCarCurrentStatus(CarCollection cars) {
        for (Car car : cars.getCars()) {
            view.printCarCurrentStatus(car.getName(), car.getCurrentLocation());
        }
    }

}
