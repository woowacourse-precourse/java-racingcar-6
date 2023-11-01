package racingcar;

import java.util.List;
import racingcar.InputView.InputView;
import racingcar.service.RacingCar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int tryCount = inputView.getRoundNumber();

        RacingCar racingCar = new RacingCar(carNames, tryCount);
        racingCar.start();
        List<String> winners = racingCar.Winners();

        racingCar.printResult();
        racingCar.printWinners(winners);
    }
}
