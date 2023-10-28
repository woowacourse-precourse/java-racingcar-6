package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    Car car;

    @BeforeEach
    void setCar() {
        car = new Car("test");
    }

    @DisplayName("자동차를 생성하면 첫 위치는 0이어야 한다.")
    @Test
    void 자동차_초기_생성_테스트() {
        //when
        String name = car.getName();
        int position = car.getPosition();

        //then
        assertThat(name).isEqualTo("test");
        assertThat(position).isEqualTo(0);
    }

    @DisplayName("자동차는 0~3사이의 숫자를 받으면 이동하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_정지_조건_테스트(int number) {
        //when
        car.move(number);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 4~9사이의 숫자를 받으면 이동하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진_조건_테스트(int number) {
        //when
        car.move(number);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
