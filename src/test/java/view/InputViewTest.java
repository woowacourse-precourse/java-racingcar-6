package view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void getCarNames() {
        String inputCarNames = "abc,def,ghi";
        String[] carNames = inputCarNames.split(",");

        assertThat(carNames).contains("def", "abc", "ghi");
        assertThat(carNames).containsExactly("abc", "def", "ghi");
    }

    @DisplayName("시도 횟수는 String으로 입력받는다.")
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