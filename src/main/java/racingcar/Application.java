package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputManager.getCarNames();
        int rounds = InputManager.getRounds();

        Game game = new Game(carNames, rounds);
        game.play();
    }
}
