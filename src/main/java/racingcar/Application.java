package racingcar;

import racingcar.controller.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();

        game.setRace();
        game.setRound();
        game.printResultStart();

        while (game.isRoundRemain()) {
            game.runSingleRound();
            game.printResult();
            game.subtractOneRound();
        }

        game.printResultEnd();
    }
}
