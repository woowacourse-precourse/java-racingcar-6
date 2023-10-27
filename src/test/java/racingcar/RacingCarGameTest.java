package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.RacingCarGame;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarGameTest {

    @ParameterizedTest
    @MethodSource("provideNamesForValidate")
    void 자동차_이름_입력값_검증_테스트(String[] carNames) {
        assertThatThrownBy(() -> RacingCarGame.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNamesForValidate() {
        return Stream.of(
                Arguments.of((Object) new String[] {"jy", "jy", "wb"}),
                Arguments.of((Object) new String[] {"jy", "juyeon", "wb"}),
                Arguments.of((Object) new String[] {"jy", "", "wb"}),
                Arguments.of((Object) new String[] {"jy", " ", "wb"})
        );
    }
}
