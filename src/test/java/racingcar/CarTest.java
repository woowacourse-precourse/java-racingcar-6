package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("이름이 5글자가 넘으면 에러가 발생한다.")
    @Test
    public void createCar1() {
        assertThatThrownBy(() -> new Car("123456"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5글자 이하면 에러가 발생하지 않는다.")
    @Test
    public void createCar2() {
        new Car("12345");
    }
}
