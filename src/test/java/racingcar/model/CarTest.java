package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void createCar_자동차가_잘_생성되는지_확인() {
        String carName = "ho";
        Car car = Car.makeCarByName(carName);

        assertEquals(carName, car.getName());
        assertEquals(0, car.getDistance());
    }

    @Test
    void go_메서드를_호출했을때_거리가_늘어나는지_확인() {
        Car car = Car.makeCarByName("ho");
        car.go();

        assertEquals(1, car.getDistance());
    }

    @Test
    void go_메서드를_중복_호출_했을때_적용되는지_확인() {
        Car car = Car.makeCarByName("Car3");
        car.go();
        car.go();
        car.go();

        assertEquals(3, car.getDistance());
    }
}
