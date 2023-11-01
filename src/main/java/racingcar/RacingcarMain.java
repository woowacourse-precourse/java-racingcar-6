package racingcar;

import java.math.BigInteger;
import java.util.List;

public class RacingcarMain {
    public void start(){
        List<Racingcar> cars;
        BigInteger round;
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
