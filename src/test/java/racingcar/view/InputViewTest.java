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
}