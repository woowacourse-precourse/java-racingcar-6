package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CircuitTest {

    @Test
    @DisplayName("자동차 경주를 했을 때 MoveCondition에 따라 포지션을 이동하거나 이동하지 않는다.")
    void raceCars() {
        List<MoveCondition> conditions = List.of(
                MoveCondition.MOVE,
                MoveCondition.MOVE,
                MoveCondition.STOP,
                MoveCondition.STOP
        );

        Circuit circuit = Circuit.fromCarNames(List.of("test1", "test2", "test3", "test4"));

        List<Car> cars = circuit.raceCars(conditions);

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
        assertThat(cars.get(3).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("서킷에 들어있는 차의 개수를 반환한다.")
    void getCircuitSize() {
        Circuit circuit = Circuit.fromCarNames(List.of("test1", "test2", "test3", "test4"));

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

        Circuit circuit = Circuit.fromCarNames(List.of("test1", "test2", "test3", "test4"));
        circuit.raceCars(conditions);

        List<String> topPositionCarNames = circuit.findTopPositionCarNames();

        assertThat(topPositionCarNames)
                .hasSize(2)
                .containsExactly("test1", "test2");
    }

    @Test
    @DisplayName("서킷에는 최소 2대 이상의 자동차가 존재해야 한다.")
    void shouldThrowExceptionWhenLessThenTwo() {
        List<String> cars = List.of("test1");
        List<String> cars2 = List.of("");
        assertThrows(IllegalArgumentException.class, () -> Circuit.fromCarNames(cars));
        assertThrows(IllegalArgumentException.class, () -> Circuit.fromCarNames(cars2));
    }
}