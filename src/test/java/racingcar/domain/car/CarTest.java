package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest{

    @Test
    @DisplayName("Car 객체 생성 TEST")
    void testCarCreation() {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn("TestCar");
        when(car.getMileage()).thenReturn(10);

        assertThat("TestCar").isEqualTo(car.getName());
        assertThat(10).isEqualTo(car.getMileage());
    }

    @Test
    @DisplayName("Car recordDistance 이동 할 때 TEST")
    void testCarRecordDistanceMove() {
        Car car = new Car("TestCar");

        assertRandomNumberInRangeTest(
            () ->{
                car.recordDistance();
                assertThat(car.getMileage()).isEqualTo(1);
            },
            5
        );
    }

    @Test
    @DisplayName("Car recordDistance 이동하지 못 했을 때 TEST")
    void testCarRecordDistanceNotMove() {
        Car car = new Car("TestCar");

        assertRandomNumberInRangeTest(
            () ->{
                car.recordDistance();
                assertThat(car.getMileage()).isEqualTo(0);
            },
            3
        );
    }
}