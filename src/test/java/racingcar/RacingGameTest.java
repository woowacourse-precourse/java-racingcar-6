package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.Result;

@DisplayName("레이싱 게임 테스트")
class RacingGameTest {

    @Test
    @DisplayName("자동차 이름들 문자열이 들어왔을 경우 해당 문자열을 통해 레이싱에 참여할 자동차 리스트를 생성하며 게임 생성")
    void init_CarNameIsEntered() {
        // given
        String carNameString = "beom,sic,test";

        // when
        RacingGame racingGame = RacingGame.of(carNameString);

        // then
        List<Car> racingCarList = racingGame.getRacingCarList();
        assertAll(
                () -> assertThat(racingCarList).isNotEmpty(),
                () ->  assertThat(racingCarList).hasSize(3)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " , ", "   ", " , , "})
    void init_EmptyCarNameIsEntered_ThrownException() {
        // given
        // when

        // then
        assertThatThrownBy(() -> RacingGame.of("")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputCarNames")
    @DisplayName("Racing Game play시 레이싱 게임에 참여하는 모든 자동차가 움직이거나 정지한 결과인 Result를 return 한다.")
    void play_AllCarsHaveMovedOrStopped(String inputNameString, int count, String[] names) {
        // given
        RacingGame racingGame = RacingGame.of(inputNameString);

        // when
        List<Result> results = racingGame.play();

        List<String> resultNames = results.stream()
                .map(Result::name)
                .toList();

        // then
        assertAll(
                () -> assertThat(results).isNotEmpty(),
                () -> assertThat(results).hasSize(count),
                () -> assertThat(resultNames).containsExactlyInAnyOrder(names)
        );
    }

    private static Stream<Arguments> inputCarNames() {
        return Stream.of(
                Arguments.of("beom,pobi,woni", 3, new String[] {"beom", "pobi", "woni"}),
                Arguments.of("beom,pobi,woni,jun", 4, new String[] {"beom", "pobi", "woni", "jun"}),
                Arguments.of("beom", 1, new String[] {"beom"})
        );
    }
}
