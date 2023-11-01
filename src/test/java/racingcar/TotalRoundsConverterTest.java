package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TotalRoundsConverterTest {

    @Test
    void convert_메서드가_사용자가_입력한_문자열을_정수로_변환해_반환() {
        String input = "90";
        TotalRoundsConverter totalRoundsConverter = new TotalRoundsConverter();

        int actual = totalRoundsConverter.convert(input);

        assertThat(actual).isEqualTo(90);
    }
}
