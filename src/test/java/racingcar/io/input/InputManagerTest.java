package racingcar.io.input;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("양의 정수로 이루어진 이동 횟수를 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "300", "999999"})
    void readMovingCount(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputManager inputManager = new InputManager(reader);

        // when
        long movingCount = inputManager.readMovingCount();

        // then
        assertThat(movingCount).isEqualTo(Long.parseLong(input));
    }

    @DisplayName("입력받은 이동 횟수가 숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", ",", " ,"})
    void readMovingCountFail(String movingCountStringLiteral) {
        // given
        Reader reader = new FakeReader(movingCountStringLiteral);
        InputManager inputManager = new InputManager(reader);

        // when & then
        assertThatThrownBy(() -> inputManager.readMovingCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 이동 횟수가 0 이하의 정수라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void readMovingCountFail2(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputManager inputManager = new InputManager(reader);

        // when & then
        assertThatThrownBy(() -> inputManager.readMovingCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

}