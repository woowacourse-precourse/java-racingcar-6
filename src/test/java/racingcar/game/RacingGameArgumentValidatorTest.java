package racingcar.game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingGameArgumentValidatorTest {

    @MethodSource("carNamesProvider")
    @ParameterizedTest
    void 올바르지_않은_자동차_이름은_예외를_던진다(List<String> carNames) throws Exception {
        //when //then
        Assertions.assertThatThrownBy(() -> GameArgumentValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @MethodSource("attemptNumberProvider")
    @ParameterizedTest
    void 올바르지_않은_시도_회수는_예외를_던진다(String attemptInput) throws Exception {
        //when //then
        Assertions.assertThatThrownBy(() -> GameArgumentValidator.validateAttemptInput(attemptInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> attemptNumberProvider() {
        return Stream.of("0", "-1", "a", " ", "");
    }

    static Stream<Arguments> carNamesProvider() {
        return Stream.of(
                Arguments.of(List.of("pobi", "javaji")),
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(" ", " ")
                        , null)
        );
    }
}