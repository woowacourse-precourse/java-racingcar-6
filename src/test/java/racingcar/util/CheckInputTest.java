package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInputTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "pobi,woni,jun";
        String[] result = input.split(",");

        assertThat(result).contains("pobi", "woni", "jun");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "pobi";
        String[] result = input.split(",");

        assertThat(result).contains("pobi");
    }
}
