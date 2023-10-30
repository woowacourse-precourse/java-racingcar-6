package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;

class UserInputTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "yu,jae,young";
        String[] result = input.split(",");

        assertThat(result).containsExactly("yu", "jae", "young");
    }

    @Test
    void parseInt_메서드로_주어진_값을_변환() {
        String input = "3";
        Integer result = Integer.parseInt(input);

        assertThat(result).isEqualTo(3);
    }
}