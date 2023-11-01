package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.printer.Output;

import java.util.List;

public class RacingCarUtil {

    private Racing racing;

    public RacingCarUtil(List<Car> cars, int gameCount) {
        racing = new Racing(cars, gameCount);
    }

    private void setCarDistance(List<Car> cars) {
        for (Car car : cars) {
            car.moveStart(MakeRandomNumbers.getRandomNumbers());
            System.out.println(car.getResult());
            Output.gameResult(car.getResult());
        }
    }

    private void roundResult() {
        for (int idx = 0; idx < racing.getRound(); idx ++) {
            setCarDistance(racing.getCars());
        }
    }

    private void winner() {
        Output.winner(racing.getWinner());
    }

    public void start() {
        roundResult();
        winner();
    }
}
