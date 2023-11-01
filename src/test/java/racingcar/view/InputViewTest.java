package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private final InputView inputView = new InputView();

    @DisplayName("닉네임이 5글자 이하가 아니라면 Exception 발생한다.")
    @Test
    void isValidNameLength() {
        // given
        String nickName = "abcdef";
        // when // then
        assertThatThrownBy(() -> inputView.validateNameLength(nickName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5글자 이하만 가능합니다.");
    }
}