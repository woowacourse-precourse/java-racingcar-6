package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void Input_값_split_결과_확인() {
        String input = "a,b,c,d,e";
        String[] result = input.split(",");

        assertThat(result).contains("b", "b", "c", "e", "d");
        assertThat(result).containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    void carName_값_exception_처리_확인() {
        String[] input = {"abc", "abcde", "asdfasdfsdfg"};
        assertThatThrownBy(() -> Application.checkWrongName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void round_값_exception_처리_확인() {
        String[] input = {"asdf", "a", ""};
        for (String num : input) {
            assertThatThrownBy(() -> Application.checkWrongRound(num))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
