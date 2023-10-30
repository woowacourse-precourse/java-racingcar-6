package racingcar;

import racingcar.collaborator.race.Race;
import racingcar.game.RacingGame;
import racingcar.io.Output;
import racingcar.io.views.RaceTotalProgressView;
import racingcar.io.views.RaceView;
import racingcar.io.views.RacingGameView;

public class Application {

    public static void main(String[] args) {
        try {
            RacingGame racingGame = new RacingGame(new RacingGameView(new RaceView(), new RaceTotalProgressView()),
                    new Race());
            racingGame.play();
        } catch (IllegalArgumentException e) {
            Output.consoleLine("잘못된 동작으로 인해 프로그램을 종료합니다.");
            throw e;
        }
    }

}
