package view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void getCarNames() {
        String inputCarNames = "abc,def,ghi";
        String[] carNames = inputCarNames.split(",");

        assertThat(carNames).contains("def", "abc", "ghi");
        assertThat(carNames).containsExactly("abc", "def", "ghi");
    }

    @Test
    void getTryCount() {
        String tryCount = "5";

        assertThat(tryCount).isEqualTo("5");

        String tryCount2 = "0";

        assertThat(tryCount2).isEqualTo("0");

        String tryCount3 = "a";

        assertThat(tryCount3).isEqualTo("a");
    }
}