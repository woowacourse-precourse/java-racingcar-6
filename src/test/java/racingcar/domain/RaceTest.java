package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    private Race testRace;

    @BeforeEach
    void init() {
        testRace = new Race();
    }

    @ParameterizedTest
    @DisplayName("차량 등록 시 정상적인 이름이 입력되면 예외가 발생하지 않는다.")
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void givenGoodName_thenSuccess(final String carNames) {
        Assertions.assertThatCode(() -> testRace.enrollCars(carNames))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("차량 등록 시 5글자를 초과하는 이름이 입력될 경우 예외가 발생한다.")
    @ValueSource(strings = {"bellwin", "heoming"})
    void givenOverFiveLengthName_thenFail(final String carNames) {
        Assertions.assertThatThrownBy(() -> testRace.enrollCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자리 이하의 자동차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("차량 등록 시 입력된 이름이 없을 경우 예외가 발생한다.")
    @EmptySource
    void givenNull_thenFail(final String carNames) {
        Assertions.assertThatThrownBy(() -> testRace.enrollCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 자동차 이름이 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("차량 등록 시 이름에 공백 문자가 있을 경우 예외가 발생한다.")
    @ValueSource(strings = {"po bi", "wo ni"})
    void givenSpace_thenFail(final String carNames) {
        Assertions.assertThatThrownBy(() -> testRace.enrollCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 문자가 포함되어 있습니다.");
    }
}