package racingcar.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameUtilTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    static class 한_라운드_종료_후_출력 extends NsTest {

        @Test
        void 한_라운드_종료_후_출력_확인() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni :");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Override
        protected void runMain() {
            GameUtil gameUtil = new GameUtil();

            gameUtil.initGame();

            gameUtil.startRound();
            gameUtil.showResults();
        }
    }

    static class 게임오버 extends NsTest {

        @Test
        void 게임오버_확인() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Override
        protected void runMain() {
            GameUtil gameUtil = new GameUtil();

            gameUtil.initGame();

            gameUtil.startRound();

            assertThat(gameUtil.checkGameOver()).isEqualTo(true);
        }
    }

    static class 우승자 extends NsTest {

        @Test
        void 우승자_한_명() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni,jun", "3");
                        assertThat(output()).contains("최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP, STOP,
                    MOVING_FORWARD, STOP, STOP,
                    MOVING_FORWARD, STOP, STOP
            );
        }

        @Test
        void 우승자_두_명() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni,jun", "3");
                        assertThat(output()).contains("최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, MOVING_FORWARD, STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP
            );
        }

        @Override
        protected void runMain() {
            GameUtil gameUtil = new GameUtil();

            gameUtil.initGame();

            gameUtil.startRound();
            gameUtil.startRound();
            gameUtil.startRound();

            gameUtil.showWinners();
        }
    }
}