package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.CustomIntGenerator;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobipo", "po bip"})
    void 글자수_제한_넘긴_이름으로_자동차_생성시_예외_발생한다(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 전진횟수의_기본값은_0이다() {
        Car car = new Car("test");

        CarState state = car.summarizeCurrentState();

        assertThat(state.forwardCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,0", "5,1", "9,1"}, delimiter = ',')
    void 전진_시도_시_고른_숫자가_기준점을_넘을때만_전진횟수가_증가한다(int pickedNumber, int expectedForwardCount) {
        Car car = new Car("test", new CustomIntGenerator(pickedNumber));

        car.tryForward();
        CarState state = car.summarizeCurrentState();

        assertThat(state.forwardCount()).isEqualTo(expectedForwardCount);
    }

    @Test
    void 이름과_전진_횟수로_자동차_상태를_요약한다() {
        Car car = new Car("test");
        CarState expectedState = new CarState("test", 0);

        CarState actualState = car.summarizeCurrentState();

        assertThat(actualState).isEqualTo(expectedState);
    }
}
