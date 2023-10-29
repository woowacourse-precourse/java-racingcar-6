package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.CarDemo;

class CarDemoTest {
    @ParameterizedTest
    @DisplayName("자동차는 이름과 위치를 가진다.")
    @CsvSource(value = {"go, 1", "kim, 2"})
    void test1(final String name, final int position) {
        final CarDemo car = new CarDemo(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("실패 테스트 - 자동차 이름이 5글자를 초과한다.")
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarDemo("고민석입니다"));
    }

    @Test
    @DisplayName("숫자가 4이상이면 자동차는 전진한다.")
    void test3() {
        final CarDemo car = new CarDemo("go");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자가 3이하이면 자동차는 멈춘다.")
    void test4() {
        final CarDemo car = new CarDemo("go");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
