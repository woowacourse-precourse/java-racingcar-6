package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("분할된 이름 갯수만큼 자동차들이 생성된다.")
    void playCarsCountTest() {
        // given
        Cars cars = Cars.from("john,pobi,bob");
        List<Car> playCars = cars.getCars();

        // then
        assertThat(playCars.size()).isEqualTo(3);
    }
}
