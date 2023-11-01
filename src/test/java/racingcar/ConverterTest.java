package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void delimitCarNames_메서드로_주어진_값을_구분() {
        String input = "aaa,bbb,ccc";
        List<String> result = Converter.delimitCarNames(input);

        assertThat(result).contains("bbb", "ccc", "aaa");
        assertThat(result).containsExactly("aaa", "bbb", "ccc");
    }

    @Test
    void delimitCarNames_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "aaa";
        List<String> result = Converter.delimitCarNames(input);

        assertThat(result).containsExactly("aaa");
    }

    @Test
    void convertAttempts_메서드로_주어진_값_변환() {
        String input = "10";
        int result = Converter.convertAttempts(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void convertWinners_메서드로_주어진_값_변환() {
        List<Car> input = List.of(new Car("aaa"), new Car("bbb"), new Car("ccc"));
        List<String> result = Converter.convertWinners(input);

        assertThat(result).containsExactly("aaa", "bbb", "ccc");
    }

    @Test
    void matchWinnersConvention_메서드로_주어진_값_구분자로_연결() {
        List<String> input = List.of("aaa", "bbbb", "ccccc");
        String result = Converter.matchWinnersConvention(input);

        assertThat(result).isEqualTo("aaa,bbbb,ccccc");
    }
}