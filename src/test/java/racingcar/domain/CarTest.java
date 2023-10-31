package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


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
    void getStatus_메서드로_해당_자동차의_이름과_위치를_반환_위치가_0() {
        // given
        Car car = new Car("A", 0);
        // when
        String result = car.getStatus();
        // then
        assertThat(result).isEqualTo("A : ");
    }

    @Test
    void getStatus_메서드로_해당_자동차의_이름과_위치를_반환_위치가_1() {
        // given
        Car car = new Car("A", 1);
        // when
        String result = car.getStatus();
        // then
        assertThat(result).isEqualTo("A : -");
    }

    @Test
    void getStatus_메서드로_해당_자동차의_이름과_위치를_반환_위치가_2() {
        // given
        Car car = new Car("A", 2);
        // when
        String result = car.getStatus();
        // then
        assertThat(result).isEqualTo("A : --");
    }
}