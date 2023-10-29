package racingcar.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;

class GameEngineValidatorTest {
    private static final int MAX_SIZE = 5;

    private static String[] 생성이_안되는_케이스() {
        return new String[]{" ".repeat(MAX_SIZE + 1), "123456789"};
    }

    private static String[] 생성이_되는_케이스() {
        return new String[]{" ".repeat(MAX_SIZE), "12345"};
    }

    @Test
    void 플레이어이름이_null값이면_예외를던진다() {
        Assertions.assertThatCode(() -> new GameEngineValidator().validateIsNotNull(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 null입니다.");
    }

    @Test
    void 플레이어이름이_null값이아니면_예외를던지지_않는다() {
        Assertions.assertThatCode(() -> new GameEngineValidator().validateIsNotNull(""))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("생성이_안되는_케이스")
    void 플레이어이름이_6이상이면_예외를_던진다(String readLine) {
        Assertions.assertThatCode(() -> new GameEngineValidator().validatePlayerNames(Collections.singletonList(readLine)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 입력된 플레이어 이름의 길이는 %d, %d이하로 해주세요.", readLine.length(), MAX_SIZE);
    }

    @ParameterizedTest
    @MethodSource("생성이_되는_케이스")
    void 플레이어이름이_5이하이면_예외를_던진다(String readLine) {
        Assertions.assertThatCode(() -> new GameEngineValidator().validatePlayerNames(Collections.singletonList(readLine)))
                .doesNotThrowAnyException();
    }

}