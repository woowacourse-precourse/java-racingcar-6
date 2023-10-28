package racingcar.domain;

import racingcar.utils.InputException;
import racingcar.utils.Split;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void run() {
        Cars cars = generateCarList(InputView.inputCarName());
    }

    public Cars generateCarList(String input) {
        List<String> carNames = Split.splitString(input);
        InputException.validateNameDuplication(carNames);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            InputException.validateNameSize(carName);
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }
}
