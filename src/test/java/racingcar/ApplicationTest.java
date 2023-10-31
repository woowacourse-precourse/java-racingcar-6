package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarData;

import java.util.Arrays;
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
    void 중복된_이름이_게임이_가능한지_확인() {

        final int FIRST_CAR = 0;
        final int SECOND_CAR = 1;

        assertRandomNumberInRangeTest(
                () -> {
                    String input = "pobi,pobi";
                    List<String> carNameList = Arrays.asList(input.split(","));
                    List<RacingCar> car = RacingCarData.carData(carNameList);
                    run(input, "2");
                    assertThat(output()).contains("pobi : -", "pobi : -", "최종 우승자 : pobi,pobi");
                    assertThat(car.get(FIRST_CAR).getCarName(FIRST_CAR)
                            .equals(car.get(SECOND_CAR).getCarName(SECOND_CAR)));
                    assertThat(car.get(FIRST_CAR).getId("pobi") != car.get(SECOND_CAR).getId("pobi"));
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
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
    void 이름에_빈칸이_들어가는지_확인하는_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_영어이외에_단어가_들어가는지_확인하는_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 명단의_마지막이_이름이_아닌_쉼표로_끝나는_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 최소_두명_이상의_인원이_참가하는_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_한번도_없을_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_숫자_이외에_문자가_들어가는_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi.,woni", "1o"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
