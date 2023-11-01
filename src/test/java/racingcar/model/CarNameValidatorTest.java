package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    @Test
    void 정상_작동_케이스() {
        List<Car> carList = new ArrayList<>();
        carList.add(Car.makeCarByName("Car1"));
        carList.add(Car.makeCarByName("Car2"));
        carList.add(Car.makeCarByName("Car3"));

        CarNameValidator.validateCarNames(carList);
    }
}
