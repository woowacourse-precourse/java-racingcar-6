package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingViewTest {

    private final static RacingView view = new RacingView();

    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @Test
    @DisplayName("inputCarNames 이름 입력 시 구분자 없음 실패 테스트")
    void inputCarNames_not_in_separated_characters_fail() {

        systemIn("푸파오 레옹 민지\n");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> view.inputCarNames())
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }
}
