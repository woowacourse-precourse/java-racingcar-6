package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarConverter;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        List<Car> cars = CarConverter.convertToCars(carNames);
        Race race = new Race(cars, tryCount);
        race.run();

        List<Car> winners = race.getWinners();
        ResultView.printWinners(winners);
    }
}
