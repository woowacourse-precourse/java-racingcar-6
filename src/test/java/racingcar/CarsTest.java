package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.utils.ErrorMessages.CAR_COUNT_UNDER_MINIMUM;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

@DisplayName("Cars 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class CarsTest {

    private static final int MOVING_FORWARD = 4;

    @Test
    void 생성자는_자동차_개수가_2개_미만인_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Cars("이하늘"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_UNDER_MINIMUM);
    }

    @Test
    void 생성자는_자동차_개수가_2개_이상인_경우_리스트로_변환한다() {
        Cars cars = new Cars("이하늘,이하늘하이");

        assertEquals(cars.getCars().size(), 2);
    }

    @Test
    void findWinnerNames_메소드는_가장_많이_전진한_자동차_이름_리스트를_반환한다() {
        Cars cars = new Cars("이하늘,늘하이,이하늘하이");

        Car winnerCar = cars.getCars().get(1);
        winnerCar.move(MOVING_FORWARD);

        assertEquals(cars.findWinners().size(), 1);
    }
}
