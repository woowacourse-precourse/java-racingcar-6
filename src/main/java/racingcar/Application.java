package racingcar;

import racingcar.service.CarPlayGameImpl;
import racingcar.service.CarPrintGame;
import racingcar.service.PlayGame;

public class Application {
    public static void main(String[] args) {
        PlayGame playGame = new CarPlayGameImpl(new CarPrintGame());

        playGame.playGame();
    }
}
