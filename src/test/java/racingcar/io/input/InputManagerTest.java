package racingcar.io.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.mock.FakeReader;

class InputManagerTest {

    @DisplayName("자동차 이름 중 공백이 있을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ,", " ,haero", "haero, ,pobi"})
    void readCarNames(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputManager inputManager = new InputManager(reader);

        // when & then
        assertThatThrownBy(() -> inputManager.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

}