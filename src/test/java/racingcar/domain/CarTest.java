package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("자동차의 현재 이동거리 크기가 다를 때 비교")
    void testCompareCarDistance() {
        // given
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 5);

        // when
        int car1SmallerThanCar2 = car1.compareTo(car2);
        int car2BiggerThanCar1 = car2.compareTo(car1);

        // then
        assertThat(car1SmallerThanCar2).isEqualTo(-1);
        assertThat(car2BiggerThanCar1).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 현재 이동거리 크기가 같을 때 비교")
    void testSameDistanceCar() {
        // given
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 4);

        // when
        boolean isSameDistance = car1.hasSameDistance(car2);

        // then
        assertThat(isSameDistance).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차의 현재 이동거리를 표시")
    void testShowCarDistance() {
        // given
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 5);

        // when
        String car1DistanceString = car1.showDistance();
        String car2DistanceString = car2.showDistance();

        // then
        assertThat(car1DistanceString).isEqualTo("----");
        assertThat(car2DistanceString).isEqualTo("-----");
    }

    @Test
    @DisplayName("자동차 이동 성공 테스트")
    void testMoveSuccess() {
        // given
        Car car = new Car("car1", 0, (min, max) -> 4);

        // when
        car.move();


        // then
        assertThat(car).extracting("moveDistance").isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 실패 테스트")
    void testMoveFailed() {
        // given
        Car car = new Car("car1", 0, (min, max) -> 3);

        // when
        car.move();

        // then
        assertThat(car).extracting("moveDistance").isEqualTo(0);
    }
}