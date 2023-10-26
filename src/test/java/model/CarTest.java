package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"banana", "apple", "pineapple"})
    @DisplayName("5글자 넘는 이름 설정시 예외 발생하는지")
    public void Car_이름_설정_예외_테스트(String name) {
        //given
        String carName = name;

        //when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 미만이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"tree", "pine", "sky"})
    @DisplayName("자동차 올바른 이름 설정")
    public void Car_이름_올바른_이름_테스트(String name) {
        //given
        Car car = new Car(name);

        //when
        String carName = car.toString();

        //then
        assertThat(carName).isEqualTo(name);
    }

    @Test
    @DisplayName("서로 다른 자동차 같은 값 가질 때 비교")
    public void 서로_다른_자동차_같은_값_비교_테스트() {
        //given
        Car car = new Car("test");
        Car otherCar = new Car("tes");

        //when
        boolean result = car.isSameMovingCount(otherCar);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("서로 다른 자동차 값이 증가했을 때 서로 다른지")
    public void 서로_다른_자동차_값_증가_테스트() {
        //given
        Car car = new Car("test");
        Car otherCar = new Car("tes");

        //when
        car.increaseMovingCountIfGreater(4, 9);
        car.increaseMovingCountIfGreater(4, 9);
        boolean result = car.isSameMovingCount(otherCar);

        //then
        assertThat(result).isFalse();
    }
}
