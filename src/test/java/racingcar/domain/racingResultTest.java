package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class racingResultTest {
    Car BMW = new Car("BMW");
    Car Audi = new Car("Audi");
    Car Tesla = new Car("Tesla");
    @Test
    @DisplayName("우승자 찾기")
    void find_winner() {
        BMW.location = 1;
        Audi.location = 3;
        Tesla.location = 3;

        Cars cars = new Cars(List.of(BMW,Audi, Tesla));

        Winner winner = new Winner(cars);
        assertThat(winner.maxLocationCarName()).isEqualTo("Audi,Tesla");
    }
}
