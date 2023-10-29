package racingcar;

import racingcar.controller.checkWinner.CheckWinner;
import racingcar.controller.checkWinner.checkWinnerByMove;
import racingcar.controller.distinguish.Distinguish;
import racingcar.controller.distinguish.distinguishData;
import racingcar.controller.random.RandomMove;
import racingcar.controller.random.randomOneToNine;
import racingcar.racingCar.RacingCarGame;
import racingcar.repositoryCar.CarRepository;
import racingcar.repositoryCar.carRepositoryByList;

public class AppConfig {
    private CheckWinner checkWinner(){
        return new checkWinnerByMove();
    }
    private Distinguish distinguish(){
        return new distinguishData();
    }
    private RandomMove randomMove(){
        return new randomOneToNine();
    }
    private CarRepository carRepository(){
        return new carRepositoryByList(randomMove(), checkWinner());
    }
    public RacingCarGame racingCarGame(){
        return new RacingCarGame(distinguish(), carRepository());
    }
}
