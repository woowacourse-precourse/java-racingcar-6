package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ScannerTest {

    @Test
    void names_정상입력() {
        // given
        List<String> names = Arrays.asList("abc", "def", "ghiii");
        String input = "abc,def,ghiii";

        // when
        List<String> result = Scanner.extractNames(input);

        // then
        assertThat(result).isEqualTo(names);
    }

    @Test
    void names_너무_긴_이름() {
        String input = "aaaaaa";
        assertThatThrownBy(() -> Scanner.extractNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void names_빈_입력() {
        String input = "";
        assertThatThrownBy(() -> Scanner.extractNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String is empty");
    }

    @Test
    void round_정상입력() {
        // given
        String input = "1";

        // when
        int result = Scanner.extractRound(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void round_잘못된입력() {
        String input = "가";
        assertThatThrownBy(() -> Scanner.extractRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input is not an integer");
    }
}