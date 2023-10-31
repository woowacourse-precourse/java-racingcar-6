package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveCount;

import java.util.List;
import static org.assertj.core.api.Assertions.*;


class InputViewTest {

    private final static String INVALID_NEGATIVE_NUMBER = "이동할 횟수는 음수가 아니어야 합니다.";
    private final static String INVALID_NUMBER_FORMAT = "이동할 횟수는 숫자여야 합니다.";

    @DisplayName("이름을 쉼표(,)로 분리하는지 검증")
    @Test
    void inputCarNameTest() {
        InputView inputView = new InputView();
        String input = "pobi,woni,jun";
        List<String> names = inputView.parseNames(input);
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("이동 횟수의 형식이 숫자가 아닌 경우 검증")
    @Test
    void inputMoveTest_Format() {
        assertThatThrownBy(() -> new MoveCount("aaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NUMBER_FORMAT);
    }

    @DisplayName("이동 횟수가 음수인 경우 검증")
    @Test
    void inputMoveTest_Range() {
        assertThatThrownBy(() -> new MoveCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NEGATIVE_NUMBER);
    }
}