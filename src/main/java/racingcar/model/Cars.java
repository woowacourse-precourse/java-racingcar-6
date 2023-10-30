package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names){
        validateDuplicate(names);
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    private void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR.getMessage());
        }
    }

    public void move(){
        for(Car car : cars){
            car.moveOneStep();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
