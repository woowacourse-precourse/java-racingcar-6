package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    class CarsSuccessTest {

        static Stream<Arguments> successCarNames() {
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
    class CarsValidateTest {

        static Stream<Arguments> exceptionCarNames() {
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

    @Nested
    @DisplayName("기능 테스트")
    class CarsFunctionalTest {

        static Stream<Arguments> successCarNames() {
            return Stream.of(
                    Arguments.of(List.of("poby", "woni", "jun")),
                    Arguments.of(List.of("qm6", "cona", "k9", "motor"))
            );
        }

        @DisplayName("현재 순위 정보를 정해진 형식의 문자열 리스트로 정상적으로 반환하는지 확인")
        @ParameterizedTest
        @MethodSource("successCarNames")
        void list_현재_순위_정해진_형식의_문자열_리스트로_정상적으로_반환하는지_확인(List<String> names) {
            List<String> currentRank = Cars.of(names)
                    .receiveCurrentRank();

            assertThat(currentRank.stream()
                    .filter(name -> name.matches("(.*) : "))
                    .count()
            ).isEqualTo(
                    names.size());
        }

        @DisplayName("최종 우승자 명단을 리스트로 정상적으로 반환하는지 확인")
        @ParameterizedTest
        @MethodSource("successCarNames")
        void list_최종_우승자_명단을_리스트로_정상적으로_반환하는지_확인(List<String> names) {
            List<String> winnerNames = Cars.of(names)
                    .receiveWinnerNames();

            assertAll(
                    () -> assertThat(winnerNames.size())
                            .isGreaterThan(0),
                    () -> assertTrue(names.containsAll(winnerNames))
            );
        }
    }
}