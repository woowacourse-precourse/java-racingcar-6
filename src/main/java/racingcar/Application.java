package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();

        game.init();
        game.run(Randoms::pickNumberInRange);
        game.result();
    }
}
