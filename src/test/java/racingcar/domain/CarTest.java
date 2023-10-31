package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다.")
    void generateExceptionCarNameIsBlank() {
        //given
        String carName = "";

        // when && then
        assertThatThrownBy(() -> Car.createForStart(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과 할 경우 예외가 발생한다.")
    void generateExceptionCarNameLengthExceedFive() {
        //given
        String carName = "a".repeat(6);

        //when && then
        assertThatThrownBy(() -> Car.createForStart(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이하이고 비어있지않으면 자동차 객체가 생성이 된다.")
    void createSuccess() {
        //given
        String carName = "test";

        //when
        Car car = Car.createForStart(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getStraightCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 객체가 생성되면 전진횟수는 0이 된다.")
    void createCarStraightCountZero() {
        //given
        String carName = "test";

        //when
        Car car = Car.createForStart(carName);

        //then
        assertThat(car.getStraightCount()).isEqualTo(0);
    }
    @Test
    @DisplayName("랜덤한 값이 4 이상이면 전진한다.")
    void executeStraightRandomValueIsGreaterThanFour() {
        //given
        Car car = Car.createForStart("테스트1");

        //when
        car.moveStraight(4);

        //then
        assertThat(car.getStraightCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤한 값이 4 미만이면 정지한다.")
    void executeStopRandomValueIsLessThanFour() {
        //given
        Car car = Car.createForStart("테스트1");

        //when
        car.moveStraight(3);

        //then
        assertThat(car.getStraightCount()).isEqualTo(0);
    }
}