package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsGeneratorTest {

    private CarsGenerator carsGenerator;

    @BeforeEach()
    void init() {
        carsGenerator = CarsGenerator.getInstance();
    }

    @Test
    void 주어진_값으로_자동차_생성() {
        String input = "pobi,woni,jun";
        List<Car> cars = carsGenerator.generateCars(input);
        assertThat(cars).contains(Car.of("pobi"), Car.of("woni"), Car.of("jun"));
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 주어진_값으로_자동차_생성시_이름이_6자_글자_이상이면_예외발생() {
        String input = "pobibibi,woni,jun";

        assertThatThrownBy(() -> carsGenerator.generateCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}