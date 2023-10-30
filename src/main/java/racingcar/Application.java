package racingcar;

import racingcar.domain.game.Game;
import racingcar.domain.game.RacingGame;
import racingcar.domain.judgement.Judgement;
import racingcar.domain.judgement.RacingJudgement;
import racingcar.domain.player.RacingGameParticipant;
import racingcar.domain.player.RacingPlayer;
import racingcar.util.GameConsoleUtil;

public class Application {
        public static void main(String[] args) {
                Judgement judgement = new RacingJudgement();
                RacingPlayer player = new RacingGameParticipant(GameConsoleUtil.getInstance());
                Game racingGame = new RacingGame(judgement, player);
                racingGame.start();
        }
}
