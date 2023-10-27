package model;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import fixture.CarFixture;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRacingTrackGenerator;
import racingcar.model.RacingGame;
import racingcar.model.RacingTrackGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarRacingTrackGeneratorTest {

    @Test
    void 자동차_경주_게임을_생성한다() {
        // given
        RacingTrackGenerator<Car> racingTrackGenerator = new CarRacingTrackGenerator();
        List<Car> cars = CarFixture.createCars(List.of("test1", "test2", "test3"));
        int playCount = 5;

        // when
        RacingGame racingGame = racingTrackGenerator.create(cars, playCount);

        // then
        assertSoftly(softly -> {
            softly.assertThat(racingGame.getResult()).hasSize(3);
            softly.assertThat(racingGame.getResult().keySet()).containsExactly("test1", "test2", "test3");
            softly.assertThat(racingGame.getResult().values()).containsExactly(0, 0, 0);
        });
    }
}
