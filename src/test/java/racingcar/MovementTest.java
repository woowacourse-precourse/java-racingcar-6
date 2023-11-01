package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Movement;

public class MovementTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 멈춤(int number) {
        Movement result = Movement.from(number);

        assertThat(result).isEqualTo(Movement.STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void 전진(int number) {
        Movement result = Movement.from(number);

        assertThat(result).isEqualTo(Movement.FORWARD);
    }
}
