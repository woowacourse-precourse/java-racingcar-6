package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @Nested
    @DisplayName("자동차 이름 목록 생성")
    class CreateCars {

        private static Stream<Arguments> successCarNames() {
            return Stream.of(
                    Arguments.of(List.of("poby", "woni", "jun")),
                    Arguments.of(List.of("qm6", "cona", "k9", "motor"))
            );
        }

        @DisplayName("자동차 이름 목록을 올바르게 입력")
        @ParameterizedTest
        @MethodSource("successCarNames")
        void string_자동차_이름_목록을_올바르게_입력(List<String> names) {
            assertThatNoException().isThrownBy(() -> Cars.of(names));
        }
    }

    @Nested
    @DisplayName("자동차 이름 목록 예외")
    class ValidateCars {

        private static Stream<Arguments> exceptionCarNames() {
            return Stream.of(
                    Arguments.of(List.of(" , , ")),
                    Arguments.of(List.of(", poby")),
                    Arguments.of(List.of("poby,,jun")),
                    Arguments.of(List.of("poby,poby")),
                    Arguments.of(List.of("poby, jun")),
                    Arguments.of(List.of("pobby111,woni222"))
            );
        }

        @DisplayName("자동차 이름 목록에 유효하지 않은 자동차 이름이 있으면 예외 발생")
        @ParameterizedTest
        @MethodSource("exceptionCarNames")
        void blank_자동차_이름_목록에_유효하지_않은_자동차_이름이_있으면_예외_발생(List<String> names) {
            assertThatThrownBy(() -> Cars.of(names))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}