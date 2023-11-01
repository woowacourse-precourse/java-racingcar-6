package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤한 수가 4이상일 경우 자동차가 한 칸 움직인다.")
    void increaseMovingCountRandomNumberOver4() {
        //given
        Car car = new Car("test");
        //when
        car.move(4);
        //then
        Assertions.assertThat(car)
            .extracting("movingCount")
            .isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤한 수가 4미만일 경우 자동차가 움직이지 않는다.")
    void notIncreaseMovingCountRandomNumberLessThan4() {
        //given
        Car car = new Car("test");
        //when
        car.move(3);
        //then
        Assertions.assertThat(car)
            .extracting("movingCount")
            .isEqualTo(0);
    }
}