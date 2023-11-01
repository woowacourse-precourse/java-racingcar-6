package racingcar;

import java.util.Arrays;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game = new Game();
        game.createName();

        game.letsGo(game.tryNumber());

        System.out.print("최종 우승자 : "+game.printWinners());
    }
}
