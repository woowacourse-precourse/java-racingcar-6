package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public class LogicTest {
    @Test
    void 문자열이_5보다_클때() {
    assertThatThrownBy(() -> {
        Car car = new Car("sdfsdfsd"); })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 차가_잘_안움직이나(int movePoint) {
        Car car = new Car("Tony");
        car.go(movePoint);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void 차가_잘_움직이나(int movePoint) {
        Car car = new Car("Tony");
        car.go(movePoint);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void StreamTest() {
        Racing racing = new Racing(new String[]{"tony", "tommy"});
        assertThat(racing.computeResult()).isEqualTo(List.of(new String[]{"tony", "tommy"}));
    }

    @Test
    void 문자열_입력_테스트() {
        assertThatThrownBy(() -> {
            Racing racing = new Racing(new String[]{"tony", "sdfsdftmy"}); })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
