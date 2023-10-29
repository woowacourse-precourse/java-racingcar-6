package racingcar;

import racingcar.controller.checkWinner.CheckWinner;
import racingcar.controller.checkWinner.checkWinnerByMove;
import racingcar.controller.distinguish.Distinguish;
import racingcar.controller.distinguish.distinguishName;
import racingcar.controller.distinguish.distinguishNumber;
import racingcar.controller.random.RandomMove;
import racingcar.controller.random.randomOneToNine;
import racingcar.racingCar.RacingCarGame;

public class AppConfig {
    private CheckWinner checkWinner(){
        return new checkWinnerByMove();
    }
    private Distinguish distinguishName(){
        return new distinguishName();
    }
    private Distinguish distinguishNumber(){
        return new distinguishNumber();
    }
    private RandomMove randomMove(){
        return new randomOneToNine();
    }
    public RacingCarGame racingCarGame(){
        return new RacingCarGame(distinguishNumber(), distinguishName(), checkWinner(), randomMove());
    }
}
