package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TotalRoundsConverterTest {

    @Test
    void convert_메서드가_사용자가_입력한_문자열을_정수로_변라환해_반환() {
        String input = "90";
        TotalRoundsConverter totalRoundsConverter = new TotalRoundsConverter();

        int actual = totalRoundsConverter.convert(input);

        assertThat(actual).isEqualTo(90);
    }

    @Test
    void convert_메서드가_checkIsDigit_메서드를_호출해_사용자_입력값에_숫자_문자가_아닌_문자가_있으면_예외_발생() {
        String input = "90회";
        TotalRoundsConverter totalRoundsConverter = new TotalRoundsConverter();

        assertThatThrownBy(() -> totalRoundsConverter.convert(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
