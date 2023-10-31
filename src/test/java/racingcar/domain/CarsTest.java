package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));
        carList.get(0).moveForward(5);
        carList.get(2).moveForward(5);

        cars = new Cars(carList);
    }

    @DisplayName("가장 먼 거리에 있는 자동차 찾기 테스트")
    @Test
    void findFarthestPositionCarTest() {
        String expectedName = "test1";

        Car maxPositionCar = cars.findFarthestPositionCar();
        String maxPositionCarName = maxPositionCar.getName();

        assertThat(maxPositionCarName).isEqualTo(expectedName);
    }

    @DisplayName("또 다른 가장 먼 거리에 있는 자동차들 찾기 테스트")
    @Test
    void findSamePositionCarTest() {
        String expectedName = "test3";
        Car maxPositionCar = cars.findFarthestPositionCar();

        List<Car> maxPositionCars = cars.findSamePositionCar(maxPositionCar);
        String otherMaxPositionCarName = maxPositionCars.get(1).getName();

        assertThat(otherMaxPositionCarName).isEqualTo(expectedName);
    }

    @DisplayName("경주의 우승자를 찾는 기능 테스트")
    @Test
    void findWinnersTest() {
        String expected1 = "test1";
        String expected2 = "test3";

        List<Car> winners = cars.findWinners();
        String winnerName1 = winners.get(0).getName();
        String winnerName2 = winners.get(1).getName();

        assertThat(winnerName1).isEqualTo(expected1);
        assertThat(winnerName2).isEqualTo(expected2);
    }
}