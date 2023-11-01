package racingcar.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomRacingCarMoveStrategyTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void _이동전략은_0에서3까지의_랜덤값은_거짓을_반환합니다(final int input) {
        assertThat(new RandomRacingCarMoveStrategy(() -> input).isMovable())
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void _이동전략은_4에서9까지의_랜덤값은_참을_반환합니다(final int input) {
        assertThat(new RandomRacingCarMoveStrategy(() -> input).isMovable())
                .isTrue();
    }

}