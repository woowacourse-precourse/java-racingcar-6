package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingMachineTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        cars = Cars.from(carNames);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void RacingMachine_생성자는_올바른_tryCount가_들어오지_않으면_IllegalArgumentException기_발생한다(int number) {
        assertThatThrownBy(() -> new RacingMachine(cars, number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

