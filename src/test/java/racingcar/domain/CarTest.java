package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_랜덤숫자가_4_이상_나왔을_때_차량_이동() {
        // given
        Car car = new Car("A", 0);
        // when
        car.move(4);
        int movingDistance = car.getMovingDistance();
        // then
        assertThat(movingDistance).isEqualTo(1);
    }

    @Test
    void move_랜덤숫자가_4_미만_나왔을_때_차량_이동_없음() {
        // given
        Car car = new Car("A", 0);
        // when
        car.move(3);
        int movingDistance = car.getMovingDistance();
        // then
        assertThat(movingDistance).isEqualTo(0);
    }

    @Test
    void getStatus() {
    }
}