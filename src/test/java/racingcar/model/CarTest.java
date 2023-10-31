package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.enums.Common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class CarTest {

    @Test
    void 잘못된_입력_테스트() {
        assertThatThrownBy(() -> new Car("-1,1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_입력_테스트_2() {
        assertThatThrownBy(() -> new Car("isaacHan")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(String.format("%d글자", Common.CAR_NAME_MAX_LENGTH.getIntValue()));
    }

    @Test
    void getName() {
        Car car = new Car("isaac");
        assertThat(car.getName()).isEqualTo("isaac");
    }

    // TODO : void에 대한 검증은 어떻게 조금 더 공부해보기
    @Test
    void moveForward() {
        Car car = new Car("isaac");
        assertRandomNumberInRangeTest(() -> {
            car.moveForward();
            assertThat(car.getDistance()).isEqualTo("");
        }, Common.STANDARD_NUMBER.getIntValue() - 1);
    }

    @Test
    void getDistance() {
        Car car = new Car("isaac");
        assertRandomNumberInRangeTest(() -> {
            car.moveForward();
            assertThat(car.getDistance()).isEqualTo("-");
        }, Common.STANDARD_NUMBER.getIntValue());
    }
}