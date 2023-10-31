package racingcar;

import static org.assertj.core.api.Assertions.*;

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
    @MethodSource("getNameInput")
    void 정상_동작_테스트(String input, List<String> names) {
        List<String> carNames = InputManager.getCarNames("aaa,bbb");
        assertThat(carNames).contains("aaa", "bbb");
    }

    @ValueSource
    private static Stream<Arguments> getNameInput() {
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
                .hasMessageContaining("마지막 글자가 콤마가 될 수 없습니다!");
    }

    @Test
    void 자동차_이름의_길이_예외_테스트() {
        assertThatThrownBy(() -> InputManager.getCarNames("name,123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");

        assertThatThrownBy(() -> InputManager.getCarNames("1234567,123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름의_공백_예외_테스트() {
        assertThatThrownBy(() -> InputManager.getCarNames("name, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름에는 공백이 아닌 문자가 한개 이상 포함되어야 합니다.");

        assertThatThrownBy(() -> InputManager.getCarNames("   ,abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름에는 공백이 아닌 문자가 한개 이상 포함되어야 합니다.");
    }

    @Test
    void 자동차_이름의_개수_제한_예외_테스트() {
        String input = makeToMuchNameInput();
        assertThatThrownBy(() -> InputManager.getCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 개수가 너무 많습니다!");
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
                .hasMessageContaining("0 이상의 int 정수가 아닙니다!");
        assertThatThrownBy(() -> InputManager.getMoveTryCount("1234567891234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 int 정수가 아닙니다!");

        assertThat(InputManager.getMoveTryCount("1234"))
                .isEqualTo(1234);
    }
}