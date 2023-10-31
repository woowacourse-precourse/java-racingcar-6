package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberTest {

    @Test
    void parseLong_입력_받은_문자열이_올바른_형식인지_확인1() {
        String input = "5";

        assertThat(Long.parseLong(input))
                .isEqualTo(5L);
    }

    @Test
    void parseLong_입력_받은_문자열이_올바른_형식인지_확인2() {
        String input = "12.3";

        assertThatThrownBy(() -> Long.parseLong(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void parseLong_입력_받은_문자열이_올바른_형식인지_확인3() {
        String input = "abc";

        assertThatThrownBy(() -> Long.parseLong(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void parseLong_입력_받은_문자열이_올바른_형식인지_확인4() {
        String input = "3000000000";

        assertThat(Long.parseLong(input))
                .isEqualTo(3000000000L);
    }
}
