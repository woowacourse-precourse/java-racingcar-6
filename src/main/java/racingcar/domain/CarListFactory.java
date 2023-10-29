package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constant.*;

public class CarListFactory {

    public CarList create(String input) {
        List<Car> list = new ArrayList<>();

        String[] carNames = input.split(INPUT_DELIM);
        for (String carName : carNames) {
            checkValid(carName);
            Car car = new Car(carName);
            list.add(car);
        }

        return new CarList(list);
    }

    private void checkValid(String name){
        if(name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(ERROR_INPUT_NAME);
    }
}
