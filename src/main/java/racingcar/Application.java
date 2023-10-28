package racingcar;

import racingcar.domain.AskPlayer;
import racingcar.domain.Cars;

public class Application {
    public static void main(String[] args) {
        AskPlayer askPlayer = new AskPlayer();
        Cars c = askPlayer.askName();
        c.getCars();
    }
}
