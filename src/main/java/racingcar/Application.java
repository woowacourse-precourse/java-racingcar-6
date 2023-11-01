package racingcar;

import java.util.List;
import racingcar.game.RacingGame;
import racingcar.model.RacingCar;
import racingcar.util.RacingGameConsole;

public class Application {
    public static void main(String[] args) {
        List<RacingCar> racingCars = RacingGameConsole.readRacingCars();
        int endLap = RacingGameConsole.readEndLap();

        RacingGame racingGame = new RacingGame(racingCars, endLap);

        racingGame.run();
    }
}
