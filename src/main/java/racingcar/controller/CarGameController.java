package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGameController {
    private final int GAME_END_NUMBER = 0;
    private Game game;
    private Cars cars;
    private CarNames carNames;

    public CarGameController() {
        this.game = new Game();
    }

    public void start() {
        OutputView.printRequestCarNameMessage();
        String input = InputView.readCarName();
        processInput(input);
        OutputView.printRequestTryNumberMessage();
        int tryNumber = Integer.parseInt(InputView.readTryNumber());
        printResult(tryNumber);
    }

    public void processInput(String input) {
        carNames = new CarNames(game.splitCarName(input));
        createCars(carNames.getNames());
    }

    public void printResult(int tryNumber) {
        List<Car> movedCars = new ArrayList<>();
        OutputView.printResultStartMessage();
        while (tryNumber-- > GAME_END_NUMBER) {
            movedCars = cars.moveAll();
            OutputView.printGameResultMessage(movedCars);
        }
        OutputView.printFinalWinner(game.judgeWinner(movedCars));
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> carList = carNames.stream().map(carName -> new Car(carName)).collect(Collectors.toList());
        this.cars = new Cars(carList);
        return carList;
    }

}
