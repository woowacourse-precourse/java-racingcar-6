package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void 이름_정상_분리() {
        String name = "Kim,Park,Lee";
        RacingGame rg = new RacingGame(name);

        assertThat(rg.racingCars).extracting("name").contains("Kim", "Park", "Lee");
    }

    @Test
    void 이름_공백_예외() {
        String name = "Kim, ,Lee";
        assertThatThrownBy(() -> {RacingGame rg = new RacingGame(name);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionString.BLANK_NAME);
    }

    @Test
    void 이름_공백_처리() {
        String name = "   Kim  ,  Park  ,  Lee";
        RacingGame rg = new RacingGame(name);
        assertThat(rg.racingCars).extracting("name").contains("Kim", "Park", "Lee");
    }

    @Test
    void 자동차_단일_처리() {
        String name = "Kim";
        RacingGame rg = new RacingGame(name);
        rg.playGame(1);
        assertThat(output()).contains("Kim : ", "최종 우승자 : Kim");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
