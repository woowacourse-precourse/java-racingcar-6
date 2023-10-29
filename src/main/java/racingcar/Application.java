package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputController.readCarNames();
        int tryCount = InputController.readTryCount();

        Game game = new Game(carNames, tryCount);
        game.play();

        List<String> winners = game.getWinners();
        OutputController.printWinners(winners);
    }
}
