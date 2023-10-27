package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("3개의 자동차 생성 됐는지 확인")
    @Test
    void test() {
        // given
        Cars cars = new Cars("pobi,woni,jun");

        // then
        assertThat(cars.getCarList()).hasSize(3);
    }

    @DisplayName("5글자 초과되는 자동차 있으면 오류")
    @Test
    void test2() {
        // then
        assertThatThrownBy(() -> new Cars("pobis2,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하로 입력해 주세요.");
    }

}