package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {

    @ParameterizedTest
    @MethodSource("generateDuplicatedNames")
    @DisplayName("중복된 이름이 있으면 예외가 발생한다.")
    void givenDuplicateNames_Then_ExceptionOccurs(final List<String> names) {
        assertThatThrownBy(() -> Cars.fromNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateDuplicatedNames() {
        return Stream.of(
                Arguments.of(List.of("pobi", "pobi", "woni")),
                Arguments.of(List.of("pobi", "lsh", "woni", "pobi"))
        );
    }

    @Test
    @DisplayName("중복된 이름이 없다면 예외가 발생하지 않는다.")
    void givenUniqueNames_Then_NoExceptionOccurs() {
        assertThatCode(() -> Cars.fromNames(List.of("pobi", "woni", "jun")))
                .doesNotThrowAnyException();
    }
}
