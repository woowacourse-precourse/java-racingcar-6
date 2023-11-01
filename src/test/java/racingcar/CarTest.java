package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarTest {
    @Test
    @DisplayName("자동차는 이름과 위치를 가진다.")
    void test1() {
        //given
        final String name = "고민석";
        final int position = 0;

        //when
        final Car car = new Car("고민석");

        //then
        assertThat(name).isEqualTo(car.getName());
        assertThat(position).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("실패 테스트 - 자동차 이름이 5글자를 초과한다.")
    void test2() {
        //given
        final String name = "다섯글자초과";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name));
    }

    @Test
    @DisplayName("자동차는 전진한다.")
    void test3() {
        //given
        final Car car = new Car("고민석");
        final int position = 1;

        //when
        car.move(5);

        //then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
