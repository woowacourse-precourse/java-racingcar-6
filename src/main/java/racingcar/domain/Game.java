package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

import racingcar.validate.Validator;
import racingcar.view.View;

public class Game {
    private List<Car> cars;
    private int attempts;
    View view = new View();

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        view.printStartMessage();
        String carNames = getCarNames();
        List<String> carNameList = splitCarNames(carNames);
        Validator.validateLenOfCarNames(carNameList);
        Validator.validateNumOfCars(carNameList);
        cars = makeCarNameList(carNameList);
        attempts = getAttempts();
    }

    private String getCarNames() {
        return Console.readLine();
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private List<Car> makeCarNameList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private int getAttempts() {
        view.printAttemptsMessage();
        int attempts = Integer.parseInt(Console.readLine());
        Validator.validateNumOfAttempts(attempts);
        return attempts;
    }

    public void playGame() {
        System.out.println();
        view.printResultMessage();
        for (int attempt = 0; attempt < attempts; attempt++) {
            makeCarMove();
            view.printCurrentStatus(cars);
        }
    }

    private void makeCarMove() {
        for (Car car : cars) {
            car.moveCar();
        }
    }
}
