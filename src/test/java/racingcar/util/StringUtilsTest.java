package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    @Test
    void splitByComma_메서드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        List<String> result = StringUtils.splitByComma(input);

        assertThat(result).contains("pobi", "jun", "woni");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void splitByComma_입력값_null_은_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.splitByComma(null);
        });
    }

    @Test
    void splitByComma_빈문자열은_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.splitByComma("   ");
        });
    }

    @Test
    void joinByComma_메서드로_주어진_값을_연결() {
        List<String> input = List.of("pobi", "woni", "jun");
        String result = StringUtils.joinByComma(input);

        assertThat(result).contains("pobi", "jun", "woni");
        assertThat(result).isEqualTo("pobi, woni, jun");
    }

    @Test
    void joinByComma_메서드에_null값은_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.joinByComma(null);
        });
    }

    @Test
    void parseInt_메서드로_한자리수_문자열을_정수로_변환() {
        String input = "4";
        int result = StringUtils.parseInt(input);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void parseInt_메서드로_5자리수_문자열을_정수로_변환() {
        String input = "41234";
        int result = StringUtils.parseInt(input);

        assertThat(result).isEqualTo(41234);
    }

    @Test
    void parseInt_숫자_이외의_문자는_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.parseInt("4ab4");
        });
    }

    @Test
    void parseInt_공백_문자는_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.parseInt("   ");
        });
    }

    @Test
    void parseInt_null_은_예외_발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.parseInt(null);
        });
    }
}
