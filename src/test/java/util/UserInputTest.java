package util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @AfterEach
    public void reset() {
        System.setIn(System.in);
    }
    @Test
    void 사용자_inputMoveCount_입력_테스트() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int moveCount = UserInput.inputMoveCount();
        assertThat(moveCount).isEqualTo(5);
    }

    @Test
     void 사용자_inputMoveCount_문자열_입력_테스트() {
        String input = "잘못된입력\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(UserInput::inputMoveCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @Test
    void 사용자_입력테스트_차이름_입력_inputCarNames() {
        String input = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String[] carNames = UserInput.inputCarNames();

        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    void 사용자_입력_negative_테스트_inputCarNames() {
        String input = "엄청나게긴이름의자동차의이름,car2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(UserInput::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다: " + "엄청나게긴이름의자동차의이름");
    }
}