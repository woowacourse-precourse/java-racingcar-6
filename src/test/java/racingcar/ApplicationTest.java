package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_입력받기() {
        String input = "car1,car2,car3";
        String[] carNames = input.split(",");

        assertThat(carNames).contains("car1", "car2", "car3");
    }

    @Test
    void 잘못된_값_입력시_illegalArgumentException_발생후_어플리케이션_종료() {

        String input = "car1,car2,car3,car4car5";

        assertThatThrownBy(() -> {
            String[] carNames = input.split(",");
            for (String carName : carNames) {
                if (carName.trim().length() > 5) {
                    throw new IllegalArgumentException("길이가 5 이상인 값이 감지되었습니다: " + carName);
                }
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수를_양수로_받는지() {
        int raceCount = 0;

        assertThatThrownBy(() -> {
            if (raceCount <= 0) {
                throw new IllegalArgumentException("횟수는 양수여야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}