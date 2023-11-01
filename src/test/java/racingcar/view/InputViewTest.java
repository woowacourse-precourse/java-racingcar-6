package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("입력된 차 이름 String을 쉼표 기준으로 파싱한다.")
    @Test
    void string_쉼표기준으로_파싱() {
        // given
        String input = "a,b,c";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.readCarName();


        // then
        assertEquals(3, carNames.size());
        assertThat(carNames).contains("a", "b", "c");
        assertThat(carNames).containsExactly("a", "b", "c");
    }
}