package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Game game = new Game();
            game.run();
        } finally {
            Console.close();
        }
    }
}
