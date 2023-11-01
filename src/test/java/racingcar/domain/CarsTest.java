package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("중복된 이름이 있으면 오류 처리")
    @Test
    void test3() {
        assertThatThrownBy(() -> new Cars("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름 : pobi");

    }

    @DisplayName("자동차 이름 1개 라도 입력 안하면 오류 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", ","})
    void test4(String carsName) {
        assertThatThrownBy(() -> new Cars(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이싱에 필요한 자동차 이름이 없습니다.");

    }
}