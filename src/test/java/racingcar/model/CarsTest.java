package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.fixture.CarsFixture;
import racingcar.helper.StubNumberGenerator;
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
    void 랜덤값이_각각_4이상이면_차가_움직인다() {
        // given
        NumberGenerator numberGenerator = new StubNumberGenerator(5);

        // when
        cars.moveAll(numberGenerator);

        // then
        assertSoftly(softly -> {
            cars.getCars()
                    .forEach(car -> {
                        assertThat(car.getPosition()).isEqualTo(1);
                    });
        });
    }

    @Test
    void 랜덤값이_각각_4미만이면_차가_그대로이다() {
        // given
        NumberGenerator numberGenerator = new StubNumberGenerator(3);

        // when
        cars.moveAll(numberGenerator);

        // then
        assertSoftly(softly -> {
            cars.getCars()
                    .forEach(car -> {
                        assertThat(car.getPosition()).isEqualTo(0);
                    });
        });
    }

    @Test
    void 가장많이_이동한_자동차의_이름을_반환한다() {
        // given
        List<Car> carsList = cars.getCars();
        Car carA = carsList.get(0);
        carA.move(new StubNumberGenerator(5));

        // when
        List<String> result = this.cars.getWinnerNames();

        // then
        assertThat(result).containsExactly("A");
    }
}
