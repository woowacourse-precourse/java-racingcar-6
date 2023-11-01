package service;

import camp.nextstep.edu.missionutils.Console;
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
        String input = Console.readLine();
        validate.inputLineOfCarNames(input);
        return input;
    }

    public int getNumberOfAttempts() {
        askForNumbersOfAttempts();
        String input = Console.readLine();
        validate.numberOfAttemptsForm(input);
        return Integer.parseInt(input);
    }

    public void attemptOneRound(List<Car> cars) {
        cars.forEach(car -> {
            car.move();
        });
    }


    public void attempt(List<Car> cars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            attemptOneRound(cars);
            printOneRoundResult(cars);
        }
    }

    public List<String> findWinner(List<Car> cars) {
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
