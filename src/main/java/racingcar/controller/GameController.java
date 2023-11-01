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
        List<String> carNames = getCarNames();
        CarCollection carCollection = createCarCollection(carNames);
        model.saveAllCars(carCollection);

        int trialNumber = getTrialNumber();
        gameStart(trialNumber);

        List<String> winnerNames = model.getCarNameHasLongestDistance();
        view.printWinner(winnerNames);
    }

    public List<String> getCarNames() {
        String input = view.inputCarName();
        carNameValidator.validateCarNameInput(input);
        return stringParser.splitCarNames(input);
    }

    public CarCollection createCarCollection(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
        return new CarCollection(cars);
    }

    public int getTrialNumber() {
        String input = view.inputTrialNumber();
        trialNumberValidator.validateTrialNumber(input);
        return Integer.parseInt(input);
    }

    public void gameStart(int trialNumber) {
        CarCollection carCollection = model.getAllCars();

        view.printResultMessage();
        for (int i = 0; i < trialNumber; i++) {
            model.moveCars();
            printEachCarCurrentStatus(carCollection);
            view.printEnter();
        }
    }

    public void printEachCarCurrentStatus(CarCollection carCollection) {
        for (Car car : carCollection.getCars()) {
            view.printCarCurrentStatus(car.getName(), car.getCurrentLocation());
        }
    }
}
