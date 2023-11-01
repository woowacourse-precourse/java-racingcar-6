package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ValueSource(strings = {"English"})
    @ParameterizedTest
    void 시도_횟수는_숫자만_가능(String input) {
        InputView inputView = new InputView();
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}