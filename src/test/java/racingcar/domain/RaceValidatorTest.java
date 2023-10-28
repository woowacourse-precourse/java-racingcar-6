package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RaceValidatorTest {
    @ParameterizedTest
    @MethodSource("provideCarNames")
    void 자동차의_개수가_2대_이상이_아니라면_예외를_발생시킨다(List<CarName> carNames) {
        assertThatThrownBy(() -> RaceValidator.validateCarCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 자동차의 개수는 2대 이상이어야 합니다.");
    }

    static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of(List.of(new CarName("car"))),
                Arguments.of(Collections.emptyList())
        );
    }
}
