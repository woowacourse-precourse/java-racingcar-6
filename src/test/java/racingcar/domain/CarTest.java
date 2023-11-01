package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "4,1", "7,1"})
    @DisplayName("랜덤값이 4이상일 때 전진하는 기능 테스트")
    void goForwardTest(int random, int expected) {
        // given
        Car car = new Car("lion");

        // when
        car.goForward(random);

        // then
        assertThat(car.getMovement()).isEqualTo(expected);
    }
}