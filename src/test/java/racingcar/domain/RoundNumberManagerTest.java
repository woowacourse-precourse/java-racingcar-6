package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RoundNumberManagerTest {
    @Test
    void checkRoundNumberExceptions_기호_입력(){
        RoundNumberManager manager = new RoundNumberManager();

        assertThatThrownBy(() -> manager.checkRoundNumberExceptions("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 숫자가 맞는지 확인해주세요.");
    }

    @Test
    void checkRoundNumberExceptions_음수_입력(){
        RoundNumberManager manager = new RoundNumberManager();

        assertThatThrownBy(() -> manager.checkRoundNumberExceptions("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 0이상의 수가 맞는지 확인해주세요.");
    }
}