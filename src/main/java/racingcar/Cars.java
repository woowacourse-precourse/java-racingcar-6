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

    private Car firstElement() {
        return cars.get(0);
    }
            }
        }
    }
}
