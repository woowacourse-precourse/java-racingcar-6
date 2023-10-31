package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 성공")
    void CarsTest() {
        // given
        String inputNames = "pobi,yoni";

        // when
        Cars cars = new Cars(inputNames);

        // then
        Assertions.assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되면 실패")
    void CarsTestFailByBlank() {
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
    @DisplayName("자동차 이름이 1개 입력되면 실패")
    void CarsTestFailByCarCount() {
        // given
        String inputNames = "pobi";

        // then
        assertThatThrownBy(() -> new Cars(inputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 실패")
    void CarsTestFailByDuplicate() {
        // given
        String inputNames = "pobi,pobi";

        // then
        assertThatThrownBy(() -> new Cars(inputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
