package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"sdfjlvo14n", "121@fsh", "non-separable-words"})
    @DisplayName("쉼표로 분할할 수 없는 이름이면 예외가 발생한다.")
    void isNotNumeric_Then_ExceptionOccurs(final String names) {
        assertThatThrownBy(() -> Cars.withNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateDuplicatedNames")
    @DisplayName("중복된 이름이 있으면 예외가 발생한다.")
    void givenDuplicateNames_Then_ExceptionOccurs(final String names) {
        assertThatThrownBy(() -> Cars.withNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateDuplicatedNames() {
        return Stream.of(
                Arguments.of("pobi,pobi,woni"),
                Arguments.of("pobi,lsh,woni,pobi")
        );
    }

    @Test
    @DisplayName("중복된 이름이 없다면 예외가 발생하지 않는다.")
    void givenUniqueNames_Then_NoExceptionOccurs() {
        assertThatCode(() -> Cars.withNames("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 움직이지 않은 경우 경주 이동한 거리는 0이다.")
    void isAllCarsStopped_Then_ZeroScoreReturns(final String names) {
        // given
        Cars cars = Cars.withNames(names);
        CarSpeedGenerator zeroSpeedGenerator = () -> 0;

        // when
        cars.moveForward(zeroSpeedGenerator);
        List<RaceScore> scores = cars.getScores();

        // then
        assertThat(scores.size()).isEqualTo(3);
        String[] carNames = names.split(",");

        for (int i = 0; i < scores.size(); i++) {
            assertThat(scores.get(i).name()).isEqualTo(carNames[i]);
            assertThat(scores.get(i).score()).isEqualTo(0);
        }
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 거리는 1이다.")
    void isAllCarsMoveForward_Then_OneScoreReturns(final String names) {
        // given
        Cars cars = Cars.withNames(names);
        CarSpeedGenerator validSpeedGenerator = () -> 4;

        // when
        cars.moveForward(validSpeedGenerator);
        List<RaceScore> scores = cars.getScores();

        // then
        assertThat(scores.size()).isEqualTo(3);
        String[] carNames = names.split(",");

        for (int i = 0; i < scores.size(); i++) {
            assertThat(scores.get(i).name()).isEqualTo(carNames[i]);
            assertThat(scores.get(i).score()).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 모두 우승자이다.")
    void isAllCarsMoveForward_Then_AllWinnersReturns(final String names) {
        // given
        Cars cars = Cars.withNames(names);
        CarSpeedGenerator validSpeedGenerator = () -> 4;

        // when
        cars.moveForward(validSpeedGenerator);
        Winners winners = Winners.from(cars.getMostForwarded());
        List<String> winnerNames = winners.getNames();

        // then
        assertThat(winnerNames.size()).isEqualTo(3);
        String[] carNames = names.split(",");
        assertThat(winnerNames).containsExactly(carNames);
    }

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of("pobi,woni,jun"),
                Arguments.of("pribi,lsh,woni")
        );
    }
}
