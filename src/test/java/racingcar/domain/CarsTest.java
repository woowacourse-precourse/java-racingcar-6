package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"pobi", "pobi,", "pobi,woni", "pobi,woni,jun"})
    @DisplayName("자동차 이름들이 주어졌을 때 cars 생성 성공")
    void givenNames_whenCreateCars_thenNoException(String names) {
        assertThatNoException().isThrownBy(() -> new Cars(names));
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", ",", "pobi, "})
    @DisplayName("자동차 이름들이 주어졌을 때 cars 생성 실패")
    void givenNames_whenCreateCars_thenThrowException(String names) {
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
