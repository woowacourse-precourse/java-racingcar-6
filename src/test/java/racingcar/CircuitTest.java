package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.service.Circuit;

public class CircuitTest {

    @Test
    @DisplayName("가장 많이 전진한 자동차인 우승자가 한 명일때")
    void forward_the_most_is_winner() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(RacingCar.of("pobi").runAndReturnNewCar(4L),
                        RacingCar.of("loopi"), RacingCar.of("evo"))
        );

        Circuit circuit = new Circuit(cars);
        assertThat(circuit.getWinner()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 여러 대여서 우승자가 여려명 일때")
    void forward_many_winners() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(RacingCar.of("pobi").runAndReturnNewCar(4L),
                        RacingCar.of("loopi").runAndReturnNewCar(4L), RacingCar.of("evo"))
        );

        Circuit circuit = new Circuit(cars);
        assertThat(circuit.getWinner()).isEqualTo("pobi, loopi");

    }

    @Test
    @DisplayName("차들이 없을 때 예외처리")
    void throw_NoSuchElementException_when_has_NoCars() {
        assertThatThrownBy(() -> {
            List<Car> cars = new ArrayList<>();
            Circuit circuit = new Circuit(cars);
            circuit.getWinner();
        }).isInstanceOf(NoSuchElementException.class);
    }

}
