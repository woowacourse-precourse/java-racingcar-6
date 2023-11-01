package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private static final String DELIMITER = ",";

    private static Message message;

    public Race() {
        message = new Message();
    }

    public void play() {
        List<Car> carList;
        int cnt;

        carList = generateCarList();
        cnt = inputCount();
        startRace(carList, cnt);
        printWinners(carList);
    }

    private List<Car> generateCarList() {
        String[] carNames;
        List<Car> carList = new ArrayList<>();

        carNames = inputNames();
        addCars(carList, carNames);
        return carList;
    }

    private String[] inputNames() {
        String input = message.inputCarNames();

        return input.split(DELIMITER);
    }

    private void addCars(List<Car> carList, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i], i));
        }
    }

    private int inputCount() {
        String input = message.inputTryNumber();

        validateInputCount(input);
        return (Integer.parseInt(input));
    }

    private void validateInputCount(String input) {
        if (input.isEmpty() || notNumber(input)) {
            throw (new IllegalArgumentException());
        }
    }

    private boolean notNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    private void startRace(List<Car> carList, int cnt) {
        message.printResultMessage();
        for (int i = 0; i < cnt; i++) {
            moveList(carList);
            message.printLineBreak();
        }
    }

    private void moveList(List<Car> carList) {
        for (Car car : carList) {
            car.move();
            message.printSingleLine(car.path());
        }
    }

    private void printWinners(List<Car> carList) {
        Collections.sort(carList);
        message.printFinalWinner(Car.winnerString(carList));
    }
}
