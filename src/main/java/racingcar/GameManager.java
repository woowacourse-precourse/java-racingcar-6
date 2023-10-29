package racingcar;

import static racingcar.view.InitialInputs.readCarNames;
import static racingcar.view.InitialInputs.readExcecutionNumber;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GameManager {
    private List<Car> cars = new ArrayList<>();
    private int executionNumber;

    public GameManager() {
        set();
    }

    private void set() {
        List<String> names = readCarNames();
        names.stream().forEach(name -> cars.add(new Car(name)));
        executionNumber = readExcecutionNumber();
    }
}
