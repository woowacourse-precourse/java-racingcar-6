package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import racingcar.exception.car_racing_manager.NotExistCarException;
import racingcar.exception.car_racing_manager.NotUniqueCarNameException;
import racingcar.helper.TestNumberGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = Cars.createWith(List.of("test1", "test2", "test3", "test4"));
    }

    @Test
    void 자동차들을_전진시키고_자동차가_전진_조건을_만족하면_전진한다() {
        // given
        int testNumber = 5;

        // when
        cars.moveAll(new TestNumberGenerator(testNumber));
        int position = cars.getVehicles().get(0).getPosition();

        // then
        assertThat(position).isEqualTo(1);
    }

    @Test
    void 게임의_참여한_모든_자동차를_반환한다() {
        // when
        List<Vehicle> vehicles = cars.getVehicles();

        // then
        assertSoftly(softly -> {
            softly.assertThat(vehicles).hasSize(4);
        });
    }

    @Test
    void 게임에_우승자를_반환한다() {
        // given
        cars.moveAll(new TestNumberGenerator(6));

        // when
        List<String> winners = cars.getWinner();

        // then
        assertSoftly(softly -> {
            softly.assertThat(winners).hasSize(4);
            softly.assertThat(winners).containsExactly("test1", "test2", "test3", "test4");
        });
    }

    @Test
    void 게임의_참여하는_자동차_중에_중복된_이름이_존재하면_예외를_발생시킨다() {
        // given
        List<String> carNames = List.of("test1", "test1", "test2");

        // when & then
        assertThatThrownBy(() -> Cars.createWith(carNames))
                .isInstanceOf(NotUniqueCarNameException.class);
    }

    @Test
    void 게임의_참여중인_자동차가_없으면_예외를_발생시킨다() {
        // given
        List<String> emptyList = List.of();

        // when & then
        assertThatThrownBy(() -> Cars.createWith(emptyList))
                .isInstanceOf(NotExistCarException.class);
    }
}
