package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"sdfjlvo14n", "121@fsh", "non-separable-words"})
    @DisplayName("쉼표로 분할할 수 없는 이름이면 예외가 발생한다.")
    void isNotNumeric_Then_ExceptionOccurs(final String names) {
        assertThatThrownBy(() -> Cars.withNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateDuplicatedNames")
    @DisplayName("중복된 이름이 있으면 예외가 발생한다.")
    void givenDuplicateNames_Then_ExceptionOccurs(final String names) {
        assertThatThrownBy(() -> Cars.withNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateDuplicatedNames() {
        return Stream.of(
                Arguments.of("pobi,pobi,woni"),
                Arguments.of("pobi,lsh,woni,pobi")
        );
    }

    @Test
    @DisplayName("중복된 이름이 없다면 예외가 발생하지 않는다.")
    void givenUniqueNames_Then_NoExceptionOccurs() {
        assertThatCode(() -> Cars.withNames("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }
}
