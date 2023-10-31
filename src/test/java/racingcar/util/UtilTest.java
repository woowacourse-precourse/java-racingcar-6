package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UtilTest {
    @Test
    void 문자열_공백_제거_테스트() {
        String input = "띄 어 쓰 기";
        String result = Util.removeSpaceAll(input);
        assertThat(result).isEqualTo("띄어쓰기");
    }
}