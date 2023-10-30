package racingcar;

import java.util.List;

public class GameHandler {
    private final Game game;

    public GameHandler(Game game) {
        this.game = game;
    }


    public void handle() {
        List<String> carNames = Communicator.instructInputCars();
        game.saveCars(carNames);

        int gameTimes = Communicator.instructInputGameTimes();
        for (int i = 0; i < gameTimes; i++) {
            game.play();
        }
    }
}
