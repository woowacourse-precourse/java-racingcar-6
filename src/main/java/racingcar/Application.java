package racingcar;

import racingcar.domain.AskPlayer;
import racingcar.domain.Cars;

public class Application {
    public static void main(String[] args) {
        AskPlayer askPlayer = new AskPlayer();
        int c = askPlayer.askHowMany();
        System.out.println("check"+c);
    }
}
