package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarFixtures.HYUK;
import static racingcar.CarFixtures.JUN;
import static racingcar.CarFixtures.POBY;
import static racingcar.CarFixtures.WONY;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsJudgeTest {

    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = List.of(
            POBY.움직인_횟수와_생성(3),
            WONY.움직인_횟수와_생성(2),
            JUN.움직인_횟수와_생성(1));
    }

    @Test
    void 판정결과_우승자를_반환한다() {
        // given
        final Cars cars = new Cars(carList);
        List<String> expected = List.of("poby");

        // when
        List<String> result = cars.judge();

        // then
        expected.forEach(name ->
            assertThat(result).isEqualTo(expected)
        );
    }


    @Test
    void 판정결과_공동우승자가_있다면_모두_반환한다() {
        // given
        final ArrayList<Car> updatedCarList = new ArrayList<>(carList);
        updatedCarList.add(HYUK.움직인_횟수와_생성(3));
        final Cars cars = new Cars(updatedCarList);

        List<String> expected = List.of("poby", "hyuk");

        // when
        List<String> result = cars.judge();

        // then
        expected.forEach(name ->
            assertThat(result).isEqualTo(expected)
        );
    }

}