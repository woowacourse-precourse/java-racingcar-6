package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void 최대_이름_길이가_5글자를_넘어가면_예외발생() {
        List<Car> carList = new ArrayList<>();
        carList.add(Car.makeCarByName("Car1"));
        carList.add(Car.makeCarByName("Car123456"));

        assertThrows(IllegalArgumentException.class,
                () -> CarNameValidator.validateCarNames(carList));
    }

    @Test
    void 중복된_이름이_있다면_예외발생() {
        List<Car> carList = new ArrayList<>();
        carList.add(Car.makeCarByName("Car1"));
        carList.add(Car.makeCarByName("Car1"));

        assertThrows(IllegalArgumentException.class,
                () -> CarNameValidator.validateCarNames(carList));
    }

    @Test
    void 빈_문자열_또는_공백만_포함된_문자열이_있다면_예외발생() {
        List<Car> carList = new ArrayList<>();
        carList.add(Car.makeCarByName(""));
        carList.add(Car.makeCarByName("  "));

        assertThrows(IllegalArgumentException.class,
                () -> CarNameValidator.validateCarNames(carList));
    }
}
