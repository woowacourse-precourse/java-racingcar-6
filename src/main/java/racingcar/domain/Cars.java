package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.exception.ErrorMessage.CAR_NAME_DUPLICATE;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicate(carNames);
        List<Car> carList = carNames.stream()
                .map(name -> new Car(name, 0))
                .toList();
        this.cars = List.copyOf(carList);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplicate(List<String> listOfNames) {
        Set<String> setOfNames = new HashSet<>(listOfNames);
        int sizeOfSet = setOfNames.size();
        int sizeOfList = listOfNames.size();

        if (sizeOfList != sizeOfSet) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
        }
    }
}
