package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingcarGame;

public class RacingcarGameTest {
    private static final int MOVE_FORWARD_COUNT_ZERO = 0;
    private static final int MOVE_FORWARD_COUNT_ONE = 1;
    private final RacingcarGame racingcarGame = new RacingcarGame();

    @DisplayName("무작위 값이 4이상일 때 이동 횟수가 1 증가한다.")
    @Test
    void 이동_횟수_증가_테스트() {
        // given
        final int RANDOM_NUMBER_THREE = 3;
        final int RANDOM_NUMBER_FOUR = 4;

        int case1 = RANDOM_NUMBER_THREE;
        int case2 = RANDOM_NUMBER_FOUR;
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");

        // when
        racingcarGame.increaseMoveForwardCount(testCar1, case1);
        racingcarGame.increaseMoveForwardCount(testCar2, case2);

        // then
        assertThat(testCar1.getMoveForwardCount()).isEqualTo(MOVE_FORWARD_COUNT_ZERO);
        assertThat(testCar2.getMoveForwardCount()).isEqualTo(MOVE_FORWARD_COUNT_ONE);
    }

    @DisplayName("이동 횟수가 가장 많은 자동차의 이름을 리스트로 반환한다.")
    @Test
    void 우승자_리스트_반환_테스트() {
        // given
        Car testCar1 = new Car("pobi");
        Car testCar2 = new Car("woni");
        Car testCar3 = new Car("jun");
        testCar1.setMoveForwardCount(MOVE_FORWARD_COUNT_ONE);
        testCar2.setMoveForwardCount(MOVE_FORWARD_COUNT_ONE);
        testCar3.setMoveForwardCount(MOVE_FORWARD_COUNT_ZERO);
        List<Car> cars = List.of(testCar1, testCar2, testCar3);
        List<String> expectedWinner = List.of("pobi", "woni");

        // when
        List<String> winner = racingcarGame.createWinner(cars);

        // then
        assertThat(winner).isEqualTo(expectedWinner);
    }
}
