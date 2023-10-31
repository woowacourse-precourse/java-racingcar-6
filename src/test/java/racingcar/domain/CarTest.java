package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5글자 이상이면 에러가 발생합니다.")
    public void CarNameTest() {
        assertThatThrownBy(() -> new Car("abcde"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상일 때는 자동차가 한 칸 앞으로 전진한다.")
    public void randomMoveTest() {
        Car car = new Car("jay");
        car.go(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 3이하일 때는 자동차가 이동하지 않는다.")
    public void randomMoveTest2() {
        Car car = new Car("jay");
        car.go(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}