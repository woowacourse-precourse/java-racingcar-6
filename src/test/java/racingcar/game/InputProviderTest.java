package racingcar.game;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputProviderTest {
    InputProvider inputProvider;
    InputStream in;

    @BeforeEach
    void setUp() {
        inputProvider = InputProvider.getInstance();
        Console.close();
    }

    @DisplayName("1글자부터 5글자까지의 이름들을 넣었을 때, 예외가 발생하지 않는지 확인합니다.")
    @Test
    void receiveCarName_WithValidInput_DoesNotThrowException() {
        String input = "a,ab,abc,abcd,abcde";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatCode(() -> inputProvider.receiveCarNames())
                .doesNotThrowAnyException();
    }

    @DisplayName("유효한 전진 횟수를 입력했을 때, 예외가 발생하지 않는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "17", "284", "5919", "19502"})
    void receiveRaceCount(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatCode(() -> inputProvider.receiveRaceCount())
                .doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 이름을 입력했을 때, 정확한 예외 메시지를 리턴하는지 확인합니다.")
    @ParameterizedTest
    @MethodSource("namesProvider")
    void receiveCarNames_WithInvalidInput_ThrowException(String input, String errorMessage) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputProvider.receiveCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("유효하지 않은 전진 횟수를 입력했을 때, 정확한 예외 메시지를 리턴하는지 확인합니다.")
    @ParameterizedTest
    @MethodSource("raceCountProvider")
    void receiveRaceCount_WithInvalidInput_ThrowException(String input, String errorMessage) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputProvider.receiveRaceCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    static Stream<Arguments> raceCountProvider() {
        return Stream.of(
                arguments(" ", "입력값이 존재하지 않습니다."),
                arguments("010", "0으로 시작할 수 없습니다."),
                arguments("abc", "경주 횟수는 1 이상의 정수값만 가능합니다."),
                arguments("-1", "경주 횟수는 1 이상의 정수값만 가능합니다.")
        );
    }

    static Stream<Arguments> namesProvider() {
        return Stream.of(
                arguments(" ", "입력값이 존재하지 않습니다."),
                arguments("a,ab,abc,abcdef", "이름은 1글자부터 5글자까지 가능합니다."),
                arguments("ab, ,abc", "입력 형식이 올바르지 않습니다."),
                arguments("a:ab:abc:abcd", "입력 형식이 올바르지 않습니다."),
                arguments("a/ab/abc/abcd", "입력 형식이 올바르지 않습니다.")
        );
    }
}