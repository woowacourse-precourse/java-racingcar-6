package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game= new Game();
        game.Start();
        String winnerResult = game.Winner();
        System.out.println(winnerResult);

        // TODO: 프로그램 구현
    }
}
