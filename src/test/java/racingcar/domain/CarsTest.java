package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    public void 이동거리가_가장_먼_자동차가_한_대일_경우() {
        Cars cars = Cars.createdByName(List.of("car1", "car2", "car3"));
        // car1: 0, car2: 0, car3: 1 만큼 이동한다.
        cars.moveAllCars(List.of(0, 0, 4));

        String winnerName = cars.findWinners().get(0).getCarName();
        assertThat(winnerName).isEqualTo("car3");
    }

    @Test
    public void 이동거리가_가장_먼_자동차가_여러_대일_경우() {
        Cars cars = Cars.createdByName(List.of("car1", "car2", "car3"));
        // car1: 1, car2: 0, car3: 1 만큼 이동한다.
        cars.moveAllCars(List.of(9, 0, 4));

        List<String> winnerNames = cars.findWinners().stream()
            .map(Car::getCarName)
            .toList();

        assertThat(winnerNames).isEqualTo(List.of("car1", "car3"));
    }
}