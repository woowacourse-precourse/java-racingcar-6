package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {

    private Parser parser = new Parser();

    @Test
    void 자동차이름_빈값_입력() {
        assertThatThrownBy(() -> parser.checkEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_5글자초과_입력() {
        assertThatThrownBy(() -> parser.checkSize("lomayd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시행횟수_빈값_입력() {
        assertThatThrownBy(() -> parser.checkEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시행횟수_문자_입력() {
        assertThatThrownBy(() -> parser.checkDigit("lomayd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
