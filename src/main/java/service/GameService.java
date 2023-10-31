package service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import util.Validate;

import java.util.List;
import java.util.stream.Collectors;

import static view.InputView.*;
import static view.OutputView.*;

public class GameService {
    CarService carService = new CarService();
    Validate validate = new Validate();
    public static final int MIN_VALUE = -1;

    public void play() {
        List<String> carNames = carService.getCarNames(getInputLineOfCarNames());
        List<Car> cars = carService.createCars(carNames);
        int numberOfAttempts = getNumberOfAttempts();
        printHeadResult();
        attempt(cars, numberOfAttempts);
        getGameResult(cars);
    }
    public String getInputLineOfCarNames() {
        askForInputCarNames();
        return validate.validateInputLineOfCarNames(Console.readLine());
    }
    public int getNumberOfAttempts() {
        askForNumbersOfAttempts();
        return Integer.parseInt(validate.checkNumberOfAttemptsForm(Console.readLine()));
    }

    private void attemptOneRound(List<Car> cars) {
        cars.forEach(car -> {
            if (isMove()) {
                car.moveForward();
            }
        });
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void attempt(List<Car> cars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            attemptOneRound(cars);
            printOneRoundResult(cars);
        }
    }

    private void printOneRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    private List<String> findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winner = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        return winner;
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = MIN_VALUE;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
    private void getGameResult(List<Car> cars) {
        String winner = String.join(",", findWinner(cars));
        printWinner(winner);
    }
}
