package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.InputView;

public class InitController {
    InputView inputView = new InputView();

    public Cars initCars() {
        List<String> names = inputView.getNames();
        return new Cars(names, new RandomNumberGenerator());
    }

    public int getRounds() {
        return inputView.getRoundNumber();
    }
}
