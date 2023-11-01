package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarGeneratorTest {

    @Test
    void 자동차_이름_부여() {
        String input = "pobi,woni,jun";
        CarGenerator carGenerator = new CarGenerator();
        List<Car> result = carGenerator.createCarList(input);

        Car car1 = result.get(0);
        Car car2 = result.get(1);
        Car car3 = result.get(2);

        assertThat(car1.getName()).isEqualTo("pobi");
        assertThat(car2.getName()).isEqualTo("woni");
        assertThat(car3.getName()).isEqualTo("jun");
    }
}
