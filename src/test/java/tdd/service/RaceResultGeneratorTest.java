package tdd.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;
import org.junit.jupiter.api.Test;
import tdd.domain.Car;

public class RaceResultGeneratorTest {
    @Test
    void 레이싱_결과가_일치하면_통과() {
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));

        assertThat(RaceResultGenerator.generate(cars).get("Car1")).isEqualTo(0);
        assertThat(RaceResultGenerator.generate(cars).get("Car2")).isEqualTo(0);

    }
}
