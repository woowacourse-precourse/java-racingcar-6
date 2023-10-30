package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarGameRoundTest {

    @DisplayName("CarRound 생성 성공 테스트")
    @Test
    void createCarRoundSuccessTest() {

        CarGameRound carGameRound = CarGameRound.createByString("1");

        assertThat(carGameRound).isNotNull();
    }

    @DisplayName("CarRound 생성 실패 테스트")
    @ValueSource(strings = {"1a2b3c", "12a", "abc"})
    @ParameterizedTest
    void createCarRoundFailTest(String inputRound) {

        assertThrows(IllegalArgumentException.class, () -> CarGameRound.createByString(inputRound));
    }
}