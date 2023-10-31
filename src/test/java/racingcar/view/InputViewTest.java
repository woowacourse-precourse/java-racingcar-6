package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("입력한 값을 split으로 배열로 만들기")
    void 이름_입력_테스트() {
        String input = "pobi,woni,jun1,!@";

        assertThat(input.split(",")).isEqualTo(new String[]{"pobi", "woni", "jun1", "!@"});
    }

    @Test
    @DisplayName("시도할 횟수 입력 테스트")
    void 시도횟수_입력_테스트() {
        int input = Integer.parseInt("123456789");

        assertThat(input).isEqualTo(123456789);
    }
}