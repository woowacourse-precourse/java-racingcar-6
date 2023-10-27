package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void checkWinner() {
        // given
        List<Car> carList1 = List.of(new Car("car1", 2));
        List<Car> carList2 = List.of(new Car("car1", 2), new Car("car2", 3), new Car("car3", 3));
        Race case1 = new Race(carList1);
        Race case2 = new Race(carList2);

        // when
        List<Car> result1 = case1.checkWinner();
        List<Car> result2 = case2.checkWinner();

        // then
        assertThat(result1.size()).as("1 winner").isEqualTo(1);
        assertThat(result2.size()).as("2 winner").isEqualTo(2);
    }
}