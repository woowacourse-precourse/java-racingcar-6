package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @DisplayName("CarName 생성 성공 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"김김김", "최최최", "박박박", "abcde"})
    void createCarNameSuccessTest(String name) {

        // given
        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName.name()).isEqualTo(name);
    }

    @DisplayName("CarName 생성 실패 테스트 - 공백")
    @Test
    void createCarNameFailTest_1() {

        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }

    @DisplayName("CarName 생성 실패 테스트 - 글자 제한")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바사아자차카타파하"})
    void createCarNameFailTest_2(String name) {

        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new CarName(name));
    }

    @DisplayName("CarName equals 성공 테스트")
    @Test
    void equalsCarNameSuccessTest_1() {

        // given
        // when
        CarName carName1 = new CarName("김씨차이름");
        CarName carName2 = new CarName("김씨차이름");

        // then
        assertThat(carName1).isEqualTo(carName2);
    }

    @DisplayName("CarName equals 성공 테스트")
    @Test
    void equalsCarNameSuccessTest_2() {

        // given
        // when
        CarName carName1 = new CarName("김씨차이름");
        CarName carName2 = new CarName("최씨차이름");

        // then
        assertThat(carName1).isNotEqualTo(carName2);
    }
}