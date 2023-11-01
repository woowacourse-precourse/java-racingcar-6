package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @DisplayName("입력되는 숫자가 4 이상이라면 이동한다.")
    @Test
    void move1() {
        Car car = new Car("12345");
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("입력되는 숫자가 3 이하라면 이동하지 않는다.")
    @Test
    void move2() {
        Car car = new Car("12345");
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}

