package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class UserInputTest {
    @Test
    @DisplayName("입력 받은 수가 숫자인지 확인")
    void isInteger() {
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        int gameCount = UserInput.getGameCount();
        assertThat(gameCount).isEqualTo(3);
    }
}
