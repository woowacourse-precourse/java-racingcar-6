package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGameController {

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
        int tryNumber = Integer.parseInt(InputView.readTryNumber());
        printResult(tryNumber);
    }


    public void processInput(String input) {
        carNames = new CarNames(game.splitCarName(input));
        validateNameLength(carNames.getNames());
        createCars(carNames.getNames());
        OutputView.printRequestTryNumberMessage();
    }

    public void printResult(int tryNumber) {
        List<Car> movedCars = new ArrayList<>();
        OutputView.printResultStartMessage();
        while (tryNumber-- > 0) {
            movedCars = cars.moveAll();
            OutputView.printGameResultMessage(movedCars);
        }
        OutputView.printFinalWinner(game.judgeWinner(movedCars));
    }


    public void validateNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }


    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        this.cars = new Cars(cars);
        return cars;
    }


}
