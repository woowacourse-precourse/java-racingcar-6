package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import racingcar.util.Generator;
import racingcar.view.OutputView;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCarsFromNames(String[] names) {
        Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void tryMovements() {
        cars.forEach(car -> {
            int number = Generator.createRandomNumber();
            car.judgeNumberToGo(number);
        });

        OutputView.printUpdatedResult(updateResult());
    }

    public String updateResult() {
        StringJoiner result = new StringJoiner("\n");
        cars.forEach(car -> result.add(car.toString()));
        return result.toString();
    }
}