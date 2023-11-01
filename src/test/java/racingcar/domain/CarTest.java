package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car create(String name) {
        return new Car.CarBuilder(name).build();
    }

    @Test
    @DisplayName("생성한 Car와 이름이 같으면 성공한다.")
    void 이름_성공_테스트() {
        //given
        Car car = create("test");
        //when, then
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("생성했을 때 거리가 0이면 성공.")
    void 거리_초기화_테스트() {
        //given
        Car car = create("test");
        //when, then
        assertThat(car.getDistance()).isZero();
    }
}