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

        Communicator.printResult();
        for (int i = 0; i < gameTimes; i++) {
            List<Car> cars = game.playOnce();
            Communicator.printProgress(cars);
        }

        List<Car> finalists = game.getFinalists();
        Communicator.printFinalists(finalists);
    }
}
