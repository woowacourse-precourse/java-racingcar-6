package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarFixtures.HYUK;
import static racingcar.CarFixtures.JUN;
import static racingcar.CarFixtures.POBY;
import static racingcar.CarFixtures.WONY;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsJudgeTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        final List<Car> cars = Arrays.asList(
            POBY.움직인_횟수와_생성(3),
            WONY.움직인_횟수와_생성(2),
            JUN.움직인_횟수와_생성(1),
            HYUK.움직인_횟수와_생성(3));
        this.cars = new Cars(cars);
    }

    @Test
    void 판정결과_공동우승자가_있다면_모두_반환한다() {
        // given
        List<String> expected = List.of("poby", "hyuk");

        // when
        List<String> result = cars.judge();

        // then
        assertThat(result.size()).isEqualTo(expected.size());
        expected.forEach(name ->
            assertThat(result.contains(name)).isTrue()
        );
    }

}