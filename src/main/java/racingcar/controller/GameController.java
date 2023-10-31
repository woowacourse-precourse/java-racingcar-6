package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.utils.CarNameValidator;
import racingcar.controller.utils.StringParser;
import racingcar.controller.utils.TrialNumberValidator;
import racingcar.model.Car;
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
        String input;
        List<String> carNames;
        List<Car> cars;
        int trialNumber;
        List<String> winnerNames;

        input = view.inputCarName();
        carNameValidator.validateCarNameInput(input);
        carNames = stringParser.splitCarNames(input);

        cars = createCarObject(carNames);
        model.saveAllCars(cars);

        input = view.inputTrialNumber();
        trialNumberValidator.validateTrialNumber(input);
        trialNumber = stringParser.toInteger(input);

        gameStart(trialNumber);

        winnerNames = model.getCarNameWithLongestDistance();
        view.printWinner(winnerNames);
    }

    private List<Car> createCarObject(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    private void gameStart(int trialNumber) {
        List<Car> cars = model.getAllCars();

        view.printResultMessage();
        for (int i = 0; i < trialNumber; i++) {
            model.fowardCars();
            for (Car car : cars) {
                view.printCurrentStatus(car.getName(), car.getCurrentLocation());
            }
            view.printEnter();
        }

    }
}
