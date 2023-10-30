package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> cars = new ArrayList<>();
    private Integer iterNumber = 0;

    public void gameStart() {
        RacingCarInputView racingCarInputView = new RacingCarInputView();

        String names = racingCarInputView.carNameInput();
        if (Validator.validateNames(names)) {
            createCars(names);
        }

        String number = racingCarInputView.carNumberInput();
        if (Validator.validateNumber(number)) {
            iterNumber = Integer.parseInt(number);
        }

        return;
    }

    public void createCars(String names) {
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

}
