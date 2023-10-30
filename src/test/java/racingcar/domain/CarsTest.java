package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("[예외처리]중복된 이름이 들어왔을 때")
    @Test
    void MakingCarsSuccessTest() {
        String[] input = {"dog", "lion", "cat"};
        assertThat(new Cars(input)).isInstanceOf(Cars.class);
    }


    @DisplayName("[예외처리]중복된 이름이 들어왔을 때")
    @Test
    void MakingCarsFailTest() {
        String[] input = {"lion", "lion", "cat"};
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 입력되었습니다.");
    }
}