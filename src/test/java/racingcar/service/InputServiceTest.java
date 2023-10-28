package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.service.InputService.*;

class InputServiceTest {
    @Test
    void convertToStringArray_쉼표로_연결된_문자열을_자동차_이름_문자열_배열로_반환() {
        String line = "긴,난,보,이,즈";

        String[] stringArray = convertToStringArray(line);

        assertThat(stringArray.length).isEqualTo(5);

        for (int i = 0; i < stringArray.length; i++)
            assertThat(stringArray[i]).isEqualTo(line.substring(i * 2, i * 2 + 1));
    }

    @Test
    void convertToStringArray_쉼표_사이에_5자_이상의_입력값에_대해_예외_발생() {
        String line = "펄잼,너바나,사운드가든,앨리스인체인스";

        assertThatThrownBy(() -> convertToStringArray(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void convertToLong_문자열을_Long형으로_변환() {
        String line = "987654321";

        assertThat(convertToLong(line)).isInstanceOf(Long.class);
    }

    @Test
    void convertToLong_숫자가_아닌_문자열에_대해_예외_발생() {
        String line = "브루트포스";

        assertThatThrownBy(() -> convertToLong(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("횟수는 숫자로만 입력해주세요.");
    }
}