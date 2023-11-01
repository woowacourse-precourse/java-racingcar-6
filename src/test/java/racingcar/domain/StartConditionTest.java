package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StartConditionTest {

    @Test
    void split_입력받은_자동차이름_구분() {
        String input = "po,ta,to";
        String[] result = input.split(",");

        assertThat(result).contains("po", "ta", "to");
        assertThat(result).containsExactly("po", "ta", "to");
    }

    @Test
    void inputAttemptNumber() {
    }
}