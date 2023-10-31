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
            // TODO : 연관관계 초기화를 어플리케이션으로 몰았더니.. 몰은 것 자체는 좋은데 너무 보기 싫다..
            RacingGame racingGame = new RacingGame(new RacingGameView(new RaceView(), new RaceTotalProgressView()),
                    new Race());
            racingGame.play();
        } catch (IllegalArgumentException e) {
            Output.consoleLine("잘못된 동작으로 인해 프로그램을 종료합니다.");
            throw e;
        }
    }

}
