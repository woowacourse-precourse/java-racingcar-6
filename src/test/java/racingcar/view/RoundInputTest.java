package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RoundInputTest extends NsTest {
    @Test
    @DisplayName("라운드_입력값_테스트")
    void readRound() {
        assertThatThrownBy(() -> runException("abcd", "q23"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
