package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.io.GameConsoleOutput;

public class Game {

    private final List<Car> cars = new ArrayList<>();
    private final int threshold;
    private final int attempt;
    private final String command;

    public Game(List<String> carNames, String attemptInput, int threshold, String command) {
        carNames.forEach(name -> cars.add(new Car(name)));
        this.attempt = Integer.parseInt(attemptInput);
        this.threshold = threshold;
        this.command = command;
    }

    public Result start() {
        GameConsoleOutput.print("실행 결과");
        gameProcess();
        return new Result(cars);
    }

    private void gameProcess() {
        int count = 0;
        while (count++ < attempt) {
            moveForward();
            showProcess();
        }
    }

    private void moveForward() {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            car.forward(threshold, randomNumber, command);
        }
    }

    private void showProcess() {
        for (Car car : cars) {
            car.showProgress();
        }

        GameConsoleOutput.print();
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
