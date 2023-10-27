package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import fixture.CarFixture;
import helper.TestNumberGenerator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;
import racingcar.model.CarRacingTrackGenerator;
import racingcar.model.RacingGame;
import racingcar.model.RacingTrackGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarRacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        RacingTrackGenerator<Car> racingTrackGenerator = new CarRacingTrackGenerator();
        List<Car> cars = CarFixture.createCars(List.of("test1", "test2", "test3", "test4"));
        racingGame = racingTrackGenerator.create(cars, 5);
    }

    @MethodSource("moveResultProvider")
    @ParameterizedTest
    void 자동차들을_전진시키고_자동차가_전진_조건을_만족하면_전진한다(int testNumber, List<Integer> expected) {
        // when
        racingGame.move(new TestNumberGenerator(testNumber));

        // then
        assertThat(racingGame.getResult().values()).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> moveResultProvider() {
        return Stream.of(
                Arguments.of(1, List.of(0, 0, 0, 0)),
                Arguments.of(4, List.of(1, 1, 1, 1)),
                Arguments.of(7, List.of(1, 1, 1, 1)));
    }

    @Test
    void 게임의_참여한_모든_자동차의_이름과_자동차의_현재_위치를_반환한다() {
        // when
        Map<String, Integer> result = racingGame.getResult();

        // then
        assertSoftly(softly -> {
            softly.assertThat(result).hasSize(4);
            softly.assertThat(result.keySet()).containsExactly("test1", "test2", "test3", "test4");
            softly.assertThat(result.values()).containsExactly(0, 0, 0, 0);
        });
    }

    @Test
    void 게임에_우승자를_반환한다() {
        // given
        racingGame.move(new TestNumberGenerator(6));

        // when
        List<String> winners = racingGame.getWinner();

        // then
        assertSoftly(softly -> {
            softly.assertThat(winners).hasSize(4);
            softly.assertThat(winners).containsExactly("test1", "test2", "test3", "test4");
        });
    }
}
