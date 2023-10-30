package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.constant.ProductConstant.LAST_NUMBER;
import static racingcar.util.constant.ProductConstant.START_NUMBER;

public class RacingCarTest extends NsTest {

    @RepeatedTest(10)
    @DisplayName("무작위 값을 생성할 때 0 ~ 9 사이의 값이 생성이 되는가?")
    void createRandomNumberValidRange() {
        int number = Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
        assertThat(number).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("무작위 값이 4 이상일 경우에만 전진해야 한다.")
    void movingForwardOnlyGreaterThanNumberFour(int value) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ha,yoon", "2");
                    assertThat(output()).contains("ha : --", "yoon : --", "최종 우승자 : ha, yoon");
                },
                value
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("무작위 값이 4 미만일 경우 전진하지 않는다.")
    void invalidMovingForwardOnlyGreaterThanNumberFour(int value) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ha,yoon", "2");
                    assertThat(output()).contains("ha : ", "yoon : ", "최종 우승자 : ha, yoon");
                },
                value
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
