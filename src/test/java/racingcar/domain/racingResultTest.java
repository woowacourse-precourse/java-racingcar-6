package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class racingResultTest {
    @Test
    @DisplayName("우승자 찾기")
    void find_max_location() {
        Car BMW = new Car("BMW");
        Car Audi = new Car("Audi");
        Car Tesla = new Car("Tesla");

        BMW.forward();
        Audi.forward();
        Audi.forward();
        Tesla.forward();
        Tesla.forward();

        Cars cars = new Cars(List.of(BMW,Audi, Tesla));

        Winner winner = new Winner(cars);
        assertThat(winner.maxLocationCarName()).isEqualTo("Audi,Tesla");
    }
}
