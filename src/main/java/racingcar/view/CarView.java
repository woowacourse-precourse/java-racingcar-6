package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public interface CarView {
    String[] inputCarNames();
    int inputGameCount();
    void outputRaceResult(List<Car> cars);
    void outputWinners(List<Car> cars);
}
