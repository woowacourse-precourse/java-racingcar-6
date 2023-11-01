package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
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
}
