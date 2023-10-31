package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarProvider;

import java.util.List;

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

    // RacingCarProvider Test
    @Test
    void 자동차_이름_유효성_검사_메서드() {
        RacingCarProvider racingCarProvider = new RacingCarProvider();
        String[] carNames =  {"pobi","woni","racingcar"};

        assertThatThrownBy(() -> racingCarProvider.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차가_생성이_되었는지_확인() {
        RacingCarProvider racingCarProvider = new RacingCarProvider();
        String[] carNames =  {"pobi","woni","sym"};

        List<RacingCar> racingCars = racingCarProvider.createRacingCars(carNames);

        assertThat(racingCars.get(0).getName())
                .isEqualTo("pobi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
