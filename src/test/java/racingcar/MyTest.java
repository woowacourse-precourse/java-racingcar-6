package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Validation;

public class MyTest {
    @Test
    void isValidName1() {
        String name1 = "a333b";
        Validation.validateName(name1);
    }

    @Test
    void isValidName2() {
        String name2 = "a@ ()";
        assertThatThrownBy(() -> Validation.validateName(name2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidName3() {
        String name3 = "abcdef";
        assertThatThrownBy(() -> Validation.validateName(name3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidCarToString() {
        String input = "abc";
        Car car = new Car(input);
        car.moveForward();
        car.moveForward();
        String result = car.toString();
        assertThat(result).isEqualTo("abc : --");
    }

    @Test
    void getBiggestDistCars() {
        String input = "abc,cde,qwe,ert";
        Cars cars = new Cars(input);
        cars.moveForwardValueOf(2);
        cars.moveForwardValueOf(2);
        cars.moveForwardValueOf(2);
        cars.moveForwardValueOf(3);
        cars.moveForwardValueOf(3);
        cars.moveForwardValueOf(3);
        cars.moveForwardValueOf(1);
        cars.moveForwardValueOf(1);
        cars.moveForwardValueOf(0);
        List<Car> biggestDistCars = cars.getBiggestDistCars();
        StringBuilder result = new StringBuilder();
        for (Car car : biggestDistCars) {
            result.append(car);
        }
        assertThat(result.toString()).isEqualTo("qwe : ---ert : ---");
    }
}
