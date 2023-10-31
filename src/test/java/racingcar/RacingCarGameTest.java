package racingcar;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RacingCarGameTest {
    private static final int MOVING_FORWARD = 1;
    private static final int STOP = 0;
    private static final int MOVING_FORWARD_THRESHOLD = 4;

    @TestFactory
    Collection<DynamicTest> 전진_또는_멈춤() {
        return List.of(
                DynamicTest.dynamicTest("임계값(4)을 넣으면 전진한다", () -> {
                    int ret = RacingCarGame.goOrStop(MOVING_FORWARD_THRESHOLD);
                    assertThat(ret).isEqualTo(MOVING_FORWARD);
                }),
                DynamicTest.dynamicTest("4이상이면 전진한다", () -> {
                    int ret = RacingCarGame.goOrStop(MOVING_FORWARD_THRESHOLD + 1);
                    assertThat(ret).isEqualTo(MOVING_FORWARD);
                }),
                DynamicTest.dynamicTest("4미만이면 멈춘다", () -> {
                    int ret = RacingCarGame.goOrStop(MOVING_FORWARD_THRESHOLD - 1);
                    assertThat(ret).isEqualTo(STOP);
                })
        );
    }

    @TestFactory
    Collection<DynamicTest> 우승자_찾기() {
        return List.of(
                DynamicTest.dynamicTest("우승자가 한 명인 경우", () -> {
                    String carNames[] = {"pobi", "woni", "brown"};
                    int progress[] = {4, 4, 3};
                    List<String> ret = RacingCarGame.findWinners(carNames, progress);
                    assertThat(ret).containsExactly("pobi", "woni");
                }),
                DynamicTest.dynamicTest("우승자가 두 명 이상인 경우", () -> {
                    String carNames[] = {"pobi", "woni", "brown"};
                    int progress[] = {4, 4, 4};
                    List<String> ret = RacingCarGame.findWinners(carNames, progress);
                    assertThat(ret).containsExactly("pobi", "woni", "brown");
                })
        );
    }
}
