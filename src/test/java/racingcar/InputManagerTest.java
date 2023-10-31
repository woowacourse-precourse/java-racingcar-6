package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputManagerTest {

    @ParameterizedTest
    @MethodSource("자동차_이름_입력_정상_동작_테스트를_위한_매개변수")
    void 자동차_이름_입력_정상_동작_테스트(String input, List<String> names) {
        List<String> carNames = InputManager.getCarNames(input);
        assertThat(carNames)
                .containsExactlyElementsOf(names);
    }

    @ValueSource
    private static Stream<Arguments> 자동차_이름_입력_정상_동작_테스트를_위한_매개변수() {
        return Stream.of(
                Arguments.of("aaa,b", Arrays.asList("aaa", "b")),
                Arguments.of("aaa ,b", Arrays.asList("aaa ", "b")),
                Arguments.of(" aaa,b", Arrays.asList(" aaa", "b")),
                Arguments.of(" aaa ,b", Arrays.asList(" aaa ", "b")),
                Arguments.of(" aaa , b ", Arrays.asList(" aaa ", " b "))
        );
    }

    @Test
    void 마지막_글자가_콤마이면_예외_테스트() {
        assertThatThrownBy(() -> InputManager.getCarNames("name,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.COMMA_MESSAGE);
    }

    @Test
    void 자동차_이름의_길이_예외_테스트() {
        assertThatThrownBy(() -> InputManager.getCarNames("name,123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_LENGTH);

        assertThatThrownBy(() -> InputManager.getCarNames("1234567,123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_LENGTH);
    }

    @Test
    void 자동차_이름의_공백_예외_테스트() {
        assertThatThrownBy(() -> InputManager.getCarNames("name, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_BLANK);

        assertThatThrownBy(() -> InputManager.getCarNames("   ,abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_BLANK);
    }

    @Test
    void 자동차_이름의_개수_제한_예외_테스트() {
        String input = makeToMuchNameInput();
        assertThatThrownBy(() -> InputManager.getCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CAR_COUNT);
    }

    private static String makeToMuchNameInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i).append(',');
        }
        sb.append(10001);
        return sb.toString();
    }

    @Test
    void 자동차_이동_시도_횟수_테스트() {
        assertThatThrownBy(() -> InputManager.getMoveTryCount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITIVE_INTEGER);
        assertThatThrownBy(() -> InputManager.getMoveTryCount("1234567891234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITIVE_INTEGER);

        assertThat(InputManager.getMoveTryCount("1234"))
                .isEqualTo(1234);
    }
}