package racingcar;

import static racingcar.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.ExceptionMessage.DUPLICATE_CAR_NAME;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    final List<Car> carList = new ArrayList<>();
    int round = 0;

    public CarList(int round, List<String> carNameSplit) {
        this.round = round;
        validateDuplicateCarName(carNameSplit);
        for(String carName : carNameSplit) {
            this.carList.add(new Car(carName));
        }
    }
    public Car getCar(int o){
        return carList.get(o);
    }

    private void validateDuplicateCarName(List<String> cars) {
        boolean hasDuplicates = cars.stream().distinct().count() < cars.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
