package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarTest.MIN_VALUE_FOR_MOVE_FORWARD;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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
        return Stream.of(
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD, MIN_VALUE_FOR_MOVE_FORWARD - 1)),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD, MIN_VALUE_FOR_MOVE_FORWARD)),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD - 1, MIN_VALUE_FOR_MOVE_FORWARD - 1))
        );
    }

    @ParameterizedTest
    @MethodSource("우승자_출력_테스트를_위한_매개변수")
    void 우승자_출력_테스트(List<String> carNames, List<Integer> movePowers, String winnerPrint) {
        Cars cars = new Cars(carNames);
        cars.tryMoveAll(movePowers);
        OutputManager.printWinner(cars);
        assertThat(output())
                .isEqualTo(winnerPrint);
    }

    static Stream<Arguments> 우승자_출력_테스트를_위한_매개변수() {
        return Stream.of(
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD, MIN_VALUE_FOR_MOVE_FORWARD - 1), "최종 우승자 : test1"),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD - 1, MIN_VALUE_FOR_MOVE_FORWARD), "최종 우승자 : test2"),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD, MIN_VALUE_FOR_MOVE_FORWARD), "최종 우승자 : test1, test2"),
                Arguments.of(List.of("test1", "test2"),
                        List.of(MIN_VALUE_FOR_MOVE_FORWARD - 1, MIN_VALUE_FOR_MOVE_FORWARD - 1),
                        "최종 우승자 : test1, test2")
        );
    }

    @Test
    void 자동차_이름_입력_가이드_출력_테스트() {
        OutputManager.printCarsNameInputGuide();
        assertThat(output())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n".trim());
    }

    @Test
    void 이동_시도_횟수_입력_가이_출력_테스트() {
        OutputManager.printMoveTryCountInputGuide();
        assertThat(output())
                .isEqualTo("시도할 회수는 몇회인가요?\n".trim());
    }
}