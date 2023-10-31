package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validation_Empty(cars);
        validation_Duplicate(cars);
        this.cars = cars;
    }

    private void validation_Duplicate(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        Set<String> carNameWithoutDuplication = new HashSet<>(carNames);

        if (carNameWithoutDuplication.size() != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_NAME_DUPLICATE);
        }
    }

    private void validation_Empty(List<Car> cars){
        if(cars.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY_CAR_LIST);
        }
    }


    public Car get(int i) {
        return cars.get(i);
    }

    public String toString() {
        return Arrays.toString(this.cars.toArray());
    }

    public int size() {
        return cars.size();
    }
}
