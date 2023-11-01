package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.round.Round;

public class CarTest {
    private Car car;
    private MovementStrategy movementStrategy;
    private Round round;

    @BeforeEach
    void setUp() {
        movementStrategy = mock(MovementStrategy.class);
        round = mock(Round.class);

        car = new Car("testCar", movementStrategy, round);
    }

    @Test
    void process_round_when_car_can_move() {
        when(movementStrategy.couldMove()).thenReturn(true);

        car.processRound();

        assertThat(car.getMovementHistory().getMovedDistance()).isEqualTo(1);

        verify(round,times(1)).proceedToNextRound();
    }

    @Test
    void process_round_when_car_can_not_move() {
        when(movementStrategy.couldMove()).thenReturn(false);

        car.processRound();

        assertThat(car.getMovementHistory().getMovedDistance()).isZero();

        verify(round,times(1)).proceedToNextRound();
    }
}
