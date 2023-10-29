package racingcar.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class GameEngineTest {
    private static final int MAX_SIZE = 5;

    private static String[] 생성이_안되는_케이스() {
        return new String[]{" ".repeat(MAX_SIZE + 1), "123456789"};
    }

    private static String[] 생성이_되는_케이스() {
        return new String[]{" ".repeat(MAX_SIZE), "12345"};
    }

    @Test
    void 플레이어이름이_null이면_예외를_던진다() {
        Assertions.assertThatCode(() -> new GameEngine(null, new ReturnOneGenerator(), new GameEngineValidator()))
                .isExactlyInstanceOf(IllegalArgumentException.class)
        ;
    }

    @ParameterizedTest
    @MethodSource("생성이_안되는_케이스")
    void 플레이어이름이_6이상이면_예외를_던진다(String readLine) {
        Assertions.assertThatCode(() -> new GameEngine(readLine, new ReturnOneGenerator(), new GameEngineValidator()))
                .isExactlyInstanceOf(IllegalArgumentException.class)
        ;
    }

    @ParameterizedTest
    @MethodSource("생성이_되는_케이스")
    void 플레이어이름이_5이하이면_예외를_던지지_않는다(String readLine) {
        Assertions.assertThatCode(() -> new GameEngine(readLine, new ReturnOneGenerator(), new GameEngineValidator()))
                .doesNotThrowAnyException();
    }

}