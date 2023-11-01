package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    @Test
    void 이름을_내부에_유지중인가() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 전진_조건이_정상적으로_반영되는가() {
        Cars cars = new Cars(new ArrayList<>());

        assertFalse(cars.decideGo(0));
        assertFalse(cars.decideGo(3));
        assertTrue(cars.decideGo(4));
        assertTrue(cars.decideGo(9));
    }

    @Test
    void 전진과_멈춤이_정상적으로_동작하는가() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        cars.get(0).go();
        cars.get(1).go();
        cars.get(2).stop();

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }
}
