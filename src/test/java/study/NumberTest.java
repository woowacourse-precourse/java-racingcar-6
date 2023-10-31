package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberTest {

    @Test
    void parseLong_입력_받은_문자열이_올바른_형식인지_확인() {
        String input1 = "5";
        String input2 = "12.3";
        String input3 = "abc";
        String input4 = "3000000000";

        assertThat(Long.parseLong(input1))
                .isEqualTo(5L);

        assertThatThrownBy(() -> Long.parseLong(input2))
                .isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(() -> Long.parseLong(input3))
                .isInstanceOf(NumberFormatException.class);

        assertThat(Long.parseLong(input4))
                .isEqualTo(3000000000L);

    }
}
