package racingcar.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;

import static org.junit.jupiter.api.Assertions.assertAll;

class WinnerEvaluatorTest {

    private final WinnerEvaluator evaluator = new WinnerEvaluator();

    @Test
    @DisplayName("우승자를 선정할 수 있다.")
    void getWinners() {
        Car woo = new Car(new Name("woo"));
        Car wa = new Car(new Name("wa"));
        Car cour = new Car(new Name("cour"));
        List<Car> cars = new ArrayList<>(Arrays.asList(woo, wa, cour));

        wa.move();

        List<String> winners = evaluator.getWinners(cars);
        assertAll(
                () -> Assertions.assertThat(winners.size()).isEqualTo(1),
                () -> Assertions.assertThat(winners.get(0)).isEqualTo(wa.getName())
        );
    }
}
