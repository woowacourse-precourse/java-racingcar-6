package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    private Car car = new Car("ham");

    @Test
    @DisplayName("car 이름을 가져올 수 있다.")
    void getCarName() {
        assertThat(car.getCarName()).isEqualTo("ham");
    }

    @Test
    @DisplayName("이동거리를 알 수 있다.")
    void getMovingLength() {
        assertThat(car.getMovingLength()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진 or 정지 확인이 가능하다.")
    void goOrStop() {
        assertThat(car.goOrStop()).contains("-");
    }

    @Test
    @DisplayName("이름이 5자초과이면 예외를 던진다.")
    void isNameLengthLessThanOrEqualFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("hamings"));
    }
}