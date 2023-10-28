package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RaceController {

    private int playCount;
    private Cars cars;

    public RaceController(Cars cars) {
        setRace();
    }

    private void setRace() {
        cars = setCar();
        playCount = setPlayCount();
    }

    private Cars setCar() {
        String inputNames = InputView.askCarName();
        return new Cars(inputNames);
    }

    private int setPlayCount() {
        return Integer.parseInt(InputView.askPlayCount());
    }
}
