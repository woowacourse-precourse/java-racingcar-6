package racingcar.domain;

import racingcar.input.Input;
import racingcar.output.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static final List<Car> cars = new ArrayList<>();
    private int round;

    public void play() {
        startGame();
        playGame();
        endGame();
    }

    private void startGame() {
        List<String> carNames = Input.getCarNames();
        round = Input.getNumber();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void playGame() {
        Output.printResult();
        for (int i = 0; i < round; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.moveForward();
        }
        Output.printRoundResult();
    }

    private void endGame() {
        Output.printWinner();
    }

    public static List<Car> getCars() {
        return cars;
    }
}
