package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarManagerTest {

    @Test
    void 전진_조건이_정상적으로_반영되는가() {
        CarManager carManager = new CarManager();

        assertFalse(carManager.decideGo(0));
        assertFalse(carManager.decideGo(3));
        assertTrue(carManager.decideGo(4));
        assertTrue(carManager.decideGo(9));
    }

    @Test
    void 최종_우승자를_판단할_수_있는가() {
        List<Car> cars = List.of(
                new Car("pobi", 1),
                new Car("woni", 2),
                new Car("jun", 3)
        );
        CarManager carManager = new CarManager(cars);
        List<Integer> winners = carManager.decideWinner();
        assertThat(winners).isEqualTo(List.of(2));

        cars = List.of(
                new Car("pobi", 2),
                new Car("woni", 2),
                new Car("jun", 1)
        );
        carManager = new CarManager(cars);
        winners = carManager.decideWinner();
        assertThat(winners).isEqualTo(List.of(0, 1));
    }
}
