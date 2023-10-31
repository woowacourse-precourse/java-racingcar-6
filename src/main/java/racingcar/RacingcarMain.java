package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingcarMain {
    public void start(){
        List<Racingcar> cars = new ArrayList<>();
        int round;
        MakeCars makeCars = new MakeCars();
        MakeRound makeRound = new MakeRound();
        RacingGame racingGame = new RacingGame();
        WinnerCheck winnerCheck = new WinnerCheck();

        cars = makeCars.makeCars();
        round = makeRound.makeRound();
        racingGame.game(cars, round);
        winnerCheck.winnerCheck(cars);
    }
}
