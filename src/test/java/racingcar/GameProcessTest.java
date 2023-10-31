package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class GameProcessTest extends NsTest {
    @Test
    void 난수가_4이상일_경우_자동차_위치_업데이트_O() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    assertThat(output()).contains("pobi : --", "최종 우승자 : pobi");
                },
                4, 4
        );
    }

    @Test
    void 난수가_4미만일_경우_자동차_위치_업데이트_X() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
                },
                3, 3
        );
    }

    @Test
    void 게임_진행_후_선두의_자동차들을_계산() {
        Cars cars = new Cars("pobi,woni,jun");
        cars.roundStatus(5);
        assertThat(cars.findWinners()).isNotNull();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
