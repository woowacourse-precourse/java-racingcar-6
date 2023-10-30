package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarRacingTest {
    @Test
    void 자동차_경주_2명_정상처리() {
        List<Car> carList = List.of(
                new Car("a"),
                new Car("b")
        );
        CarRacing carRacing = new CarRacing(carList, 3);

        CarRacingResult carRacingResult = carRacing.start(() -> 3);

        assertThat(carRacingResult.toString()).isEqualTo("최종 우승자 : a, b");
    }

    @Test
    void 자동차_경주_3명_정상처리() {
        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue"),
                new Car("hoon")
        );
        CarRacing carRacing = new CarRacing(carList, 3);

        CarRacingResult carRacingResult = carRacing.start(() -> 4);

        assertThat(carRacingResult.toString()).isEqualTo("최종 우승자 : bae, sue, hoon");
    }
}
