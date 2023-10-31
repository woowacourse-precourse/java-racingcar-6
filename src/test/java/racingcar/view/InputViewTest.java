package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("자동차 이름 입력")
    public void getInputCarName() {
        // given
        String expect = "car,name";
        systemIn(expect);

        // when
        String input = new InputView().getInputCarName();

        // then
        assertThat(input).isEqualTo(expect);
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}