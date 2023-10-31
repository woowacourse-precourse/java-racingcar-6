package racingcar;

import racingcar.collaborator.race.Race;
import racingcar.enums.ApplicationMessage;
import racingcar.game.RacingGame;
import racingcar.io.Output;
import racingcar.io.views.RaceTotalProgressView;
import racingcar.io.views.RaceView;
import racingcar.io.views.RacingGameView;

public class Application {

    public static void main(String[] args) {
        executeRacingGameApplication();
    }

    private static void executeRacingGameApplication() {
        try {
            RacingGame racingGame = getRacingGame();
            racingGame.play();
        } catch (IllegalArgumentException e) {
            Output.consoleLine(ApplicationMessage.EXCEPTION_APPLICATION.get());
            throw e;
        }
    }

    private static RacingGame getRacingGame() {
        // COMMENT : 연관관계 초기화를 어플리케이션으로 몰았더니.. 몰은 것 자체는 좋은데 너무 보기 싫다..
        return new RacingGame(
                new RacingGameView(
                        new RaceView(), new RaceTotalProgressView()
                ),
                new Race());
    }

}
