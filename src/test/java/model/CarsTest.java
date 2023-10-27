package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    public void 자동차들_생성() {
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2");
        Cars cars = new Cars(Arrays.asList(car1,car2));
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

}
