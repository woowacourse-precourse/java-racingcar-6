package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.input.Input;
import racingcar.output.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class RacingCar {
    private final List<Car> cars = new ArrayList<>();
    private int round;

    public void play() {
        startGame();
        playGame();
        endGame();
    }

    private void startGame() {
        List<String> carNames = getCarNames();
        round = getNumber();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playGame() {
        Output.printResult();
        for (int i = 0; i < round; i++) {
            playRound();
        }
    }

    private List<String> getCarNames() {
        Input.printEnterCarNames();
        String names = Console.readLine();
        String[] nameArr = names.split(",");
        return Arrays.asList((nameArr));
    }

    private int getNumber() throws IllegalArgumentException {
        Input.printEnterRound();
        String numStr = Console.readLine();
        return Integer.parseInt(numStr);
    }

    private void playRound() {
        for (Car car : cars) {
            car.moveForward();
        }
        printRoundResult();
    }

    private void printRoundResult() {
        for (Car car : cars) {
            car.printMoves();
        }
        System.out.println();
    }

    private void endGame() {
        Output.printWinner();
        printWinner();
    }

    private int getMaxMoves() {
        int maxMoves = 0;
        for (Car car : cars) {
            maxMoves = max(maxMoves, car.getMoves());
        }
        return maxMoves;
    }

    private void printWinner() {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoves() == getMaxMoves()) {
                winner.add(car.getName());
            }
        }
        System.out.println(String.join(", ", winner));
    }
}
