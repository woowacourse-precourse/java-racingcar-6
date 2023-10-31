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

}