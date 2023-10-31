package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.exception.DuplicateCarNamesException;
import racingcar.fixture.CarsFixture;
import racingcar.helper.StubNumberGenerator;
import racingcar.model.dto.RacingResult;
import racingcar.util.NumberGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = CarsFixture.createCars(List.of("A", "B", "C"));
    }

    @Test
    void 주어진_랜덤값이_4이상이면_차량이_한_번씩_움직인다() {
        // given
        NumberGenerator numberGenerator = new StubNumberGenerator(5);

        // when
        cars.moveAll(numberGenerator);

        // then
        List<RacingResult> racingStatuses = cars.getRacingStatuses();
        assertThat(racingStatuses.get(0).getCarPosition()).isEqualTo(1);
    }

    @Test
    void 주어진_랜덤값이_4미만이면_차량이_그대로_있다() {
        // given
        NumberGenerator numberGenerator = new StubNumberGenerator(3);

        // when
        cars.moveAll(numberGenerator);

        // then
        List<RacingResult> racingStatuses = cars.getRacingStatuses();
        assertThat(racingStatuses.get(0).getCarPosition()).isZero();
    }

    @Test
    void 가장많이_이동한_자동차의_이름을_반환한다() {
        // when
        List<String> result = cars.getWinnerNames();

        // then
        assertThat(result).containsExactly("A", "B", "C");
    }

    @Test
    void 중복된_자동차가_있으면_예외가_발생한다() {
        // when & then
        assertThatThrownBy(() -> Cars.from(List.of("A", "A", "A")))
                .isInstanceOf(DuplicateCarNamesException.class);
    }
}
