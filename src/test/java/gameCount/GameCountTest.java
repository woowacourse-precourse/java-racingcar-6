package gameCount;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.Exception.RacingCarException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCountTest extends NsTest {

    private RacingCarException racingCarException;

    @BeforeEach
    void setUp() {
        racingCarException = new RacingCarException();
    }

    @Test
    @DisplayName("1보다 작은 수 입력 시 예외")
    void 시도_횟수_예외_처리() {

        String input = "0";

        assertThatThrownBy(() -> racingCarException.validateGameCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 입력 시 예외")
    void 시도_횟수_공백_예외_처리() {

        String input = "";

        assertThatThrownBy(() -> racingCarException.validateGameCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자 입력 시 예외")
    void 시도_횟수_문자_예외_처리() {

        String input = "ㅁ";

        assertThatThrownBy(() -> racingCarException.validateGameCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}


