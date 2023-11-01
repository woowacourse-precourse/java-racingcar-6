package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }


    @Test
    void Car_자동차가_움직인경우_필드멤버_갱신을_확인() {
        int initalLocation = car.getLocation();
        car.canForward(Car.MIN_NUMBER_TO_MOVE);
        assertEquals(initalLocation + Car.MOVE_DISTANCE, car.getLocation());
    }

    @Test
    void Car_자동차가_움직이지_않는_경우_멤버변수가_변하지_않는다() {
        int initalLocation = car.getLocation();
        car.canForward(Car.MIN_NUMBER_TO_MOVE - 1);
        assertEquals(initalLocation, car.getLocation());
    }
}