package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.console.Input;
import racingcar.console.Output;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars = new ArrayList<>();

    public void start() {
        initializeCars();
        int rounds = getRounds();
        startRace(rounds);
    }

    private void initializeCars() {
        String carNames = Input.getCarNames();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name.trim()));
        }
    }

    private int getRounds() {
        return Input.getRounds();
    }

    private void startRace(int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            printCurrentState();
        }
        printWinner();
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private void printCurrentState() {
        for (Car car : cars) {
            Output.printCarState(car.getName(), car.getPosition());
        }
        Output.printNewLine();
    }

    private void printWinner() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        Output.printWinner(String.join(", ", winners));
    }

    private int getMaxPosition() {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}
