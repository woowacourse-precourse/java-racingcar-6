package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

    @Test
    public void 게임을_한번_진행하면_move가_한번씩_호출된다() {
        Car mock1 = mock(Car.class);
        Car mock2 = mock(Car.class);
        Car mock3 = mock(Car.class);
        Cars cars = new Cars(List.of(mock1, mock2, mock3));

        cars.moveAllCars(List.of(1, 2, 3));

        verify(mock1, Mockito.times(1)).move(1);
        verify(mock2, Mockito.times(1)).move(2);
        verify(mock3, Mockito.times(1)).move(3);
    }

    @Test
    public void Car의_수_만큼_printCarsNameAndPosition이_호출된다() {
        Car mock1 = mock(Car.class);
        Car mock2 = mock(Car.class);
        Car mock3 = mock(Car.class);
        Cars cars = new Cars(List.of(mock1, mock2, mock3));

        cars.printCarNamesAndPositions();

        verify(mock1, times(1)).printCarNameAndPosition();
        verify(mock2, times(1)).printCarNameAndPosition();
        verify(mock3, times(1)).printCarNameAndPosition();

    }
}