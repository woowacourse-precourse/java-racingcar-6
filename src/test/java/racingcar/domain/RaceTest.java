package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceTest {

    @ParameterizedTest
    @Test
    @ValueSource(strings = {"3.141592", "-1"})
    void 이동_횟수에_대한_예외_처리(String number) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Race(number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
