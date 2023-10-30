package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarGameRoundTest {

    @DisplayName("CarGameRound 생성 성공 테스트")
    @Test
    void createCarRoundSuccessTest() {

        CarGameRound carGameRound = CarGameRound.createByString("1");

        assertThat(carGameRound).isNotNull();
    }

    @DisplayName("CarGameRound 생성 실패 테스트")
    @ValueSource(strings = {"1a2b3c", "12a", "abc"})
    @ParameterizedTest
    void createCarRoundFailTest(String inputRound) {

        assertThrows(IllegalArgumentException.class, () -> CarGameRound.createByString(inputRound));
    }

    @DisplayName("CarGameRound isRunning 메서드 테스트 - 진행 중")
    @MethodSource("generateCarGameRound_Running")
    @ParameterizedTest
    void carRoundIsRunningTest_1(int finalRound, List<Integer> runningRound) {
        CarGameRound carGameRound = CarGameRound.createByString(String.valueOf(finalRound));

        for (Integer currentRound : runningRound) {
            assertThat(carGameRound.isRunning(currentRound)).isTrue();
        }
    }

    @DisplayName("CarGameRound isRunning 메서드 테스트 - 진행 중")
    @MethodSource("generateCarGameRound_End")
    @ParameterizedTest
    void carRoundIsRunningTest_2(int finalRound, int runningRound) {
        CarGameRound carGameRound = CarGameRound.createByString(String.valueOf(finalRound));

        assertThat(carGameRound.isRunning(runningRound)).isFalse();
    }


    static Stream<Arguments> generateCarGameRound_Running() {
        return Stream.of(
                Arguments.of(5, Arrays.asList(1, 2, 3, 4)),
                Arguments.of(3, Arrays.asList(1, 2))
        );
    }

    static Stream<Arguments> generateCarGameRound_End() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(3, 3)
        );
    }
}