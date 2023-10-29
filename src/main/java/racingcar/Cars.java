package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        String[] splitNames = names.split(",");
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .collect(Collectors.toList());
        validateCarNames();
    }

    private void validateCarNames() {
        InputValidator validator = new InputValidator();
        validator.nameNonInputValidate(cars.size(), firstElement().getName());
        for (Car car : cars) {
            validator.nameLengthValidate(car);
        }
    }

        for (Car car : cars) {
            if (car.isNameLongerThenCriteria(5)) {
                throw new IllegalArgumentException("5자리 이하의 이름을 입력하시오!");
            }
        }
    }
}
