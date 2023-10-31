package racingcar.carfactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    CarFactory carFactory;
    public CarFactoryTest(){
        carFactory = new CarFactory();
    }

    @Test
    void 생성된_리스트가_올바른_객체를_가지고_있는지_테스트() {
        List<String> carNames = new ArrayList<>(Arrays.asList("pobi","wooni","jun"));

        List<Car> cars = carFactory.createCars(carNames);

        Assertions.assertThat(cars.stream().map(Car::getName)).contains("pobi","wooni","jun");
    }
}