package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.Output;
import racingcar.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int attempt;
    private List<Car> cars;
    private final List<Car> result;

    public Game() {
        cars = new ArrayList<>();
        result = new ArrayList<>();
    }

    public void run() {
        inputCar();
        inputTimes();
        startGame();
        calculateWinner();
    }

    private void calculateWinner() {
        int longDistance = 0;
        for (Car car : cars) {
            longDistance = Math.max(car.getMoveDistance(), longDistance);
        }
        for (Car car : cars) {
            if (car.getMoveDistance() == longDistance)
                result.add(car);
        }
    }

    private void startGame() {
        Output.startGamePrintExcuseResult();
        excuseGame();
    }

    private void excuseGame() {
        for (int i = 0; i < attempt; i++) {
            for (Car c : cars) {
                if (!canMove())
                    continue;
                c.move();
            }
            printMoveCar();
        }
    }

    private void printMoveCar() {
        Output.moveCar(cars);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void inputTimes() {
        Output.inputAttemptNumPrint();
        String input = Input.inputAttemptNum();
        attempt = Validator.validateInputAttemptNum(input);
        
    }

    private void inputCar() {
        Output.inputCarsNamePrint();
        String input = Input.inputCarsName();
        List<String> string = Arrays.stream(input.split(",")).toList();
        Validator.validateInputCarList(string);
        cars = initCars(string);
    }

    private List<Car> initCars(List<String> validatedString) {
        return validatedString.stream().map(
                Car::new
        ).collect(Collectors.toList());
    }
}