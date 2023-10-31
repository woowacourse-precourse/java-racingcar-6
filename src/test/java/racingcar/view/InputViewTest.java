package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("입력값 중 5글자를 초과하면 IllegalArgumentException 확인")
    public void 자동차_이름_5글자_초과(){
        // given
        final InputView inputView = new InputView();

        // when
        List<String> names = Arrays.asList("lee,kim,jameson");

        // then
        assertAll(
                () -> assertThatThrownBy(() -> inputView.validateFiveCharacter(names))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputView.validateFiveCharacter(names))
                        .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다.")
        );
    }

    @Test
    @DisplayName("입력을 아라비아 숫자가 아닌 글자가 포함되면 IllegalArgumentException 확인")
    public void 아라비아_숫자_검증() {
        // given
        final InputView inputView = new InputView();

        // when
        String input = "1번";

        // then
        assertAll(
                () -> assertThatThrownBy(() -> inputView.validateArabicNumber(input))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputView.validateArabicNumber(input))
                        .hasMessageContaining("아라비아 숫자만 입력 가능합니다.")
        );
    }

    @Test
    @DisplayName("빈 값을 입력하면 IllegalArgumentException 확인")
    public void 빈_값_검증() {
        // given
        final InputView inputView = new InputView();

        // when
        String input = "";

        // then
        assertAll(
                () -> assertThatThrownBy(() -> inputView.validateEmptyInput(input))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputView.validateEmptyInput(input))
                        .hasMessageContaining("빈 값은 입력할 수 없습니다.")
        );
    }
}