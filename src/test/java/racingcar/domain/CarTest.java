package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"javaji", ""})
    void 이름에_대한_예외_처리(String name) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(name))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
