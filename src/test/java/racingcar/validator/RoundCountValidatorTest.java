package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RoundCountValidatorTest {
    @ParameterizedTest(name = "{index}:{1}")
    @MethodSource("invalidParameter")
    @DisplayName("게임 횟수 유효성 검사")
    void 게임_횟수_유효성_검사(String trialName, String testName) {
        RoundCountValidator roundCountValidator = new RoundCountValidator();
        Assertions.assertThatThrownBy(() -> roundCountValidator.validateInputGameRound(trialName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameter() {
        return Stream.of(
                Arguments.of("test","정수가 아닌 문자"),
                Arguments.of("0","Zero"),
                Arguments.of("-1", "음수")
        );
    }
}
