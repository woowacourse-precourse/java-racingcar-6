package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void 우승자_한명_리스트로_반환() {
        List<Car> input = new ArrayList<>();
        input.add(new Car("A", 1));
        input.add(new Car("B", 2));
        input.add(new Car("C", 3));

        Cars cars = new Cars(input);
        List<Car> leadingCar = cars.getLeadingCar();

        Car winner = leadingCar.get(0);
        assertThat(winner.getCount()).isEqualTo(3);
        assertThat(winner.getName()).isEqualTo("C");
    }
}
