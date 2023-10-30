package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> cars = new ArrayList<>();
    public void gameStart() {
        RacingCarInputView racingCarInputView = new RacingCarInputView();
        String names = racingCarInputView.carNameInput();
        createCars(names);
        return;
    }

    public void createCars(String names) {
        String[] carNames = names.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

}
