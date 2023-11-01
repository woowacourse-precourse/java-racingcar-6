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


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}

class RaceTest {

    @Test
    void testAccelerateItem() {
        // 아이템 "가속" 테스트
        Race race = new Race(new String[]{"CarA"}, 1, 4, 3, 2, 2, 1);
        race.startRaceWithItems();

        int[] carProgress = race.getCarProgress();
        assertThat(carProgress).containsExactly(1);
    }

    @Test
    void testStopItem() {
        // 아이템 "정지" 테스트
        Race race = new Race(new String[]{"CarA"}, 1, 4, 3, 2, 2, 1);
        race.startRaceWithItems();

        int[] carProgress = race.getCarProgress();
        assertThat(carProgress).containsExactly(0);
    }

    @Test
    void testChangePositionItem() {
        // 아이템 "위치 변경" 테스트
        Race race = new Race(new String[]{"CarA", "CarB"}, 1, 4, 3, 2, 2, 1);
        race.startRaceWithItems();

        int[] carProgress = race.getCarProgress();
        assertThat(carProgress).contains(1, 0); // "CarA"는 1, "CarB"는 0일 것
    }
}


