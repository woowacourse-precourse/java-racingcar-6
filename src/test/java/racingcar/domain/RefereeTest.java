package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private Referee referee;

    @BeforeEach
    void setUp() {
        List<Car> cars = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));
        cars.get(0).moveForward(5);
        cars.get(2).moveForward(5);

        referee = new Referee(cars);
    }

    @DisplayName("가장 먼 거리에 있는 자동차 찾기 테스트")
    @Test
    void findFarthestPositionCarTest() {
        String expectedName = "test1";

        Car maxPositionCar = referee.findFarthestPositionCar();
        String maxPositionCarName = maxPositionCar.getName();

        assertThat(maxPositionCarName).isEqualTo(expectedName);
    }

    @DisplayName("또 다른 가장 먼 거리에 있는 자동차들 찾기 테스트")
    @Test
    void findSamePositionCarTest() {
        String expectedName = "test3";
        Car maxPositionCar = referee.findFarthestPositionCar();

        List<Car> maxPositionCars = referee.findSamePositionCar(maxPositionCar);
        String otherMaxPositionCarName = maxPositionCars.get(1).getName();

        assertThat(otherMaxPositionCarName).isEqualTo(expectedName);
    }
}