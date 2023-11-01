package racingcar;

import java.util.List;

public class Game {

    private final Input input = new Input();
    private final CarManager carManager = new CarManager();
    private int tryCount;

    public void run() {
        start();
        progress();
        end();
    }

    private void start() {
        List<String> carNames = input.getInputCarNames();
        carManager.setCars(carNames);
        tryCount = input.getInputTryCount();
    }

    private void progress() {
        Output.printResult();
        while (tryCount-- > 0) {
            carManager.moveEachCar();
        }
    }

    private void end() {
        carManager.getWinner();
    }
}
