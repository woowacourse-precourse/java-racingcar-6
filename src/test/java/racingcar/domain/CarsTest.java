package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차 이름에 공백이 포함되면 실패")
    void When_IncludeBlank_Expect_Fail() {
        // given
        String inputNamesNonSpace = "pobi,";
        String inputNamesSpace = "pobi, ";

        // then
        assertThatThrownBy(() -> new Cars(inputNamesNonSpace))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(inputNamesSpace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 1개만 입력되면 실패")
    void When_CarIsOne_Expect_Fail() {
        // given
        String inputNames = "pobi";

        // then
        assertThatThrownBy(() -> new Cars(inputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 실패")
    void When_Duplicated_Expect_Fail() {
        // given
        String inputNames = "pobi,pobi";

        // then
        assertThatThrownBy(() -> new Cars(inputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
