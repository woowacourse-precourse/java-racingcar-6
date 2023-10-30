package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    void 주어진_값을_쉼표로_구분() {
        // given
        String input = "1,2,3";

        // when
        String[] result = Splitter.splitName(input);

        // then
        assertThat(result).containsExactly(result);
    }
}