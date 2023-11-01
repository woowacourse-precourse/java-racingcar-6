package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class CarTest {

    @ParameterizedTest
    @Test
    @ValueSource(strings = {"pobi,javaji", "pobi,pobi", ""})
    void 이름에_대한_예외_처리(String name) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(name))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
