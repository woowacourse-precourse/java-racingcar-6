package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.view.Output;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(String inputCarNames) {
        String[] carNameArr = inputCarNames.split(",");
        validateDuplicateName(carNameArr);
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
    }

    private void validateDuplicateName(String[] carNameArr) {
        long distinctCount = Arrays.stream(carNameArr).distinct().count();
        if (distinctCount < carNameArr.length) {
            throw new IllegalArgumentException();
        }
    }

    public void run() {
        this.carList.forEach(car -> {
            car.move();
            Output.printRunResult(car);
        });
        Output.printBlankLine();
    }

}
