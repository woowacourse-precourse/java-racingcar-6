package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.CustomIntGenerator;
import racingcar.model.intgenerator.IntGenerator;

public class CarTest {
    private Car car;
    private IntGenerator defaultIntGenerator;

    @BeforeEach
    void setUp() {
        defaultIntGenerator = new CustomIntGenerator(0);
        car = new Car("pobi", defaultIntGenerator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobipo", "po bip"})
    void 글자수_제한_넘긴_이름으로_자동차_생성시_예외_발생한다(String name) {
        assertThatThrownBy(() -> new Car(name, defaultIntGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    void 자동차_생성시_전진횟수의_기본값은_0이다() {
        CarState state = car.summarizeState();

        assertThat(state.forwardCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,0", "5,1", "9,1"}, delimiter = ',')
    void 전진_시도_시_고른_숫자가_기준점을_넘을때만_전진횟수가_증가한다(int pickedNumber, int expectedForwardCount) {
        Car customCar = new Car("pobi", new CustomIntGenerator(pickedNumber));

        customCar.tryForward();
        CarState state = customCar.summarizeState();

        assertThat(state.forwardCount()).isEqualTo(expectedForwardCount);
    }

    @Test
    void 이름과_전진_횟수로_자동차_상태를_요약한다() {
        CarState expectedState = new CarState("pobi", 0);

        CarState actualState = car.summarizeState();

        assertThat(actualState).isEqualTo(expectedState);
    }
}
