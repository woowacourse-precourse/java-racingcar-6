package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircuitTest {

    private final Car car1 = new Car("test1");
    private final Car car2 = new Car("test2");
    private final Car car3 = new Car("test3");
    private final Car car4 = new Car("test4");

    @Test
    @DisplayName("자동차 경주를 했을 때 MoveCondition에 따라 포지션을 이동하거나 이동하지 않는다.")
    void raceCars() {
        List<MoveCondition> conditions = List.of(
                MoveCondition.MOVE,
                MoveCondition.MOVE,
                MoveCondition.STOP,
                MoveCondition.STOP
        );

        Circuit circuit = Circuit.fromCarNames(List.of(car1, car2, car3, car4));

        List<Car> cars = circuit.raceCars(conditions);

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
        assertThat(cars.get(3).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("서킷에 들어있는 차의 개수를 반환한다.")
    void getCircuitSize() {
        Circuit circuit = Circuit.fromCarNames(List.of(car1, car2, car3, car4));

        assertThat(circuit.getCircuitSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("서킷에 있는 차들 중 가장 높은 포지션의 차들이 반환된다.")
    void findTopPositionCarNames() {
        List<MoveCondition> conditions = List.of(
                MoveCondition.MOVE,
                MoveCondition.MOVE,
                MoveCondition.STOP,
                MoveCondition.STOP
        );

        Circuit circuit = Circuit.fromCarNames(List.of(car1, car2, car3, car4));
        circuit.raceCars(conditions);

        List<String> topPositionCarNames = circuit.findTopPositionCarNames();

        assertThat(topPositionCarNames)
                .hasSize(2)
                .containsExactly("test1", "test2");
    }

    @Test
    @DisplayName("서킷에는 최소 2대 이상의 자동차가 존재해야 한다.")
    void shouldThrowExceptionWhenLessThenTwo() {
        List<Car> cars = List.of(car1);
        List<Car> cars2 = List.of();
        assertThrows(IllegalArgumentException.class, () -> Circuit.fromCarNames(cars));
        assertThrows(IllegalArgumentException.class, () -> Circuit.fromCarNames(cars2));
    }
}