package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @Test
    void separateCarNames_메서드로_주어진_값을_구분() {
        String input = "aaa,bbb,ccc";
        List<String> result = Converter.separateCarNames(input);

        assertThat(result).containsExactly("aaa", "bbb", "ccc");
    }

    @Test
    void separateCarNames_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "aaa";
        List<String> result = Converter.separateCarNames(input);

        assertThat(result).containsExactly("aaa");
    }

    @Test
    void convertRound_메서드로_주어진_값_변환() {
        String input = "10";
        int result = Converter.convertRound(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void convertDistance_메서드로_주어진_값_변환() {
        int input = 5;
        String result = Converter.convertDistance(input);

        assertThat(result).isEqualTo("-----");
    }

    @Test
    void convertWinners_메서드로_주어진_값_변환() {
        List<Car> input = List.of(new Car("aaa"), new Car("bbb"), new Car("ccc"));
        List<String> result = Converter.convertWinners(input);

        assertThat(result).containsExactly("aaa", "bbb", "ccc");
    }

    @Test
    void matchWinnersNameConvention_메서드로_주어진_값_구분자로_연결() {
        List<String> input = List.of("aaa", "bbbb", "ccccc");
        String result = Converter.matchWinnersNameConvention(input);

        assertThat(result).isEqualTo("aaa,bbbb,ccccc");
    }

    @Test
    void matchWinnersNameConvention_메서드_사용시_입력된_값이_한개일_경우_구분자_없이_변환() {
        List<String> input = List.of("aaa");
        String result = Converter.matchWinnersNameConvention(input);

        assertThat(result).isEqualTo("aaa");
    }
}