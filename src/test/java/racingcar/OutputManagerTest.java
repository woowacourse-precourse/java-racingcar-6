package racingcar;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OutputManagerTest extends NsTest {

    @Override
    protected void runMain() {
    }

    @ParameterizedTest
    @MethodSource("전진_테스트를_위한_매개변수")
    void 전진_테스트(List<String> carNames, List<Integer> movePowers) {
        Cars cars = new Cars(carNames);
        cars.tryMoveAll(movePowers);
        OutputManager.printCarsMoveStatus(cars);
        assertThat(output())
                .isEqualTo(cars.toString().trim());
    }

    static Stream<Arguments> 전진_테스트를_위한_매개변수() {
        final int MIN_VALUE_FOR_MOVE_FORWARD = 4;
        return Stream.of(
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD, MIN_VALUE_FOR_MOVE_FORWARD - 1)),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD, MIN_VALUE_FOR_MOVE_FORWARD)),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD - 1, MIN_VALUE_FOR_MOVE_FORWARD - 1))
        );
    }
}