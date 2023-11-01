package racingcar;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameInputTest {
    @Test
    void 이름_입력_테스트() {
        // given
        final List<String> expectedNames = Arrays.asList("pobi", "woni", "jun");
        final String input = "pobi,woni,jun";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final List<String> actualNames = UserInput.inputNames();

        // then
        Assertions.assertThat(actualNames).isEqualTo(expectedNames);
    }
}