package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.Race;

public class RaceTest {

    private Race race;
    private Car car1;
    private Car car2;

    @BeforeEach
    void 준비() {
        car1 = mock(Car.class);
        car2 = mock(Car.class);
        List<Car> cars = Arrays.asList(car1, car2);
        race = new Race(cars, 5);
    }

    @Test
    void 경주_시행() {
        race.executeRace();

        verify(car1, times(5)).move();
        verify(car2, times(5)).move();
    }

    @Test
    void 우승자_판별() {
        when(car1.getPosition()).thenReturn(5);
        when(car2.getPosition()).thenReturn(3);

        race.executeRace();
        List<Car> winners = race.getWinners();

        assertThat(winners).containsExactly(car1);
    }


    @Test
    void 최대_전진_위치_판별() {
        when(car1.getPosition()).thenReturn(3);
        when(car2.getPosition()).thenReturn(5);

        int maxPosition = race.getMaxPosition();

        assertThat(maxPosition).isEqualTo(5);
    }

    @Test
    void 우승자_존재여부() {
        List<Car> winners = race.getWinners();

        assertThat(winners).isEmpty();
    }
}
