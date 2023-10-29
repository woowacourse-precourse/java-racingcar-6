package racingcar.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

    private final Evaluator evaluator = new Evaluator();

    @Test
    @DisplayName("우승자를 판별할 수 있다.")
    void evaluateWinner() {
        Car woo = new Car("woo");
        Car wa = new Car("wa");
        Car co = new Car("co");
        List<Car> cars = new ArrayList<>(Arrays.asList(woo, wa, co));

        wa.updateMovingCount();
        co.updateMovingCount();
        co.updateMovingCount();

        List<String> winners = evaluator.evaluateWinner(cars);
        assertAll(
                () -> assertThat(winners.size()).isEqualTo(1),
                () -> assertThat(winners.get(0)).isEqualTo(co.getName())
        );
    }
}
