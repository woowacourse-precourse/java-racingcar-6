package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarGameRoundTest {

    @DisplayName("CarGameRound 생성 성공 테스트")
    @Test
    void createCarRoundSuccessTest() {

        // given
        // when
        CarGameRound carGameRound = CarGameRound.createByString("1");

        // then
        assertThat(carGameRound).isNotNull();
    }

    @DisplayName("CarGameRound 생성 실패 테스트")
    @ValueSource(strings = {"1a2b3c", "12a", "abc"})
    @ParameterizedTest
    void createCarRoundFailTest(String inputRound) {

        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> CarGameRound.createByString(inputRound));
    }

    @DisplayName("CarGameRound isRunning 메서드 테스트 - 진행 중")
    @Test
    void carRoundIsRunningTest_1() {

        // given
        // when
        CarGameRound carGameRound = CarGameRound.createByString(String.valueOf(5));

        // then
        assertThat(carGameRound.isRunning()).isTrue();
    }

    @DisplayName("CarGameRound isRunning 메서드 테스트 - 게임 종료")
    @Test
    void carRoundIsRunningTest_2() {

        // given
        // when
        CarGameRound carGameRound = CarGameRound.createByString(String.valueOf(0));

        // then
        assertThat(carGameRound.isRunning()).isFalse();
    }
}