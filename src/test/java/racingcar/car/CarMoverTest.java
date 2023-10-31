package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static racingcar.constant.Constants.MOVING_DISTANCE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.util.RandomManipulator;

class CarMoverTest {

    @Test
    void moveCars() {
        RandomManipulator randomManipulator = Mockito.mock(RandomManipulator.class);
        when(randomManipulator.isMove()).thenReturn(true);
        CarMover carMover = new CarMover(randomManipulator);

        Car car1 = new Car("jane");
        Car car2 = new Car("bam");
        List<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);

        carMover.moveCars(cars);

        int result1 = car1.getLocation();
        int result2 = car2.getLocation();

        assertThat(result1).isEqualTo(MOVING_DISTANCE);
        assertThat(result2).isEqualTo(MOVING_DISTANCE);
    }
}