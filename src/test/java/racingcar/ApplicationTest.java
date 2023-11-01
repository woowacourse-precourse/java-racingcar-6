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
    void 움직이기_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi :", "woni : -",
                            "pobi :", "woni : --", "pobi :", "woni : ---",
                            "pobi : -", "woni : ----");
                },
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD,MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차이름_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi", "woni");
                },
                STOP, MOVING_FORWARD
        );
    }
    @Test
    void 우승자_출력검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains( "최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }


    @Test
    void 우승자_출력검증2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains( "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD,MOVING_FORWARD
                ,MOVING_FORWARD,MOVING_FORWARD
        );
    }
    @Test
    void 텍스트_출력검증(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                            "시도할 회수는 몇회인가요?","실행 결과");
                },
                MOVING_FORWARD,MOVING_FORWARD
                ,MOVING_FORWARD,MOVING_FORWARD
        );

    }

    @Test
    void 종합_검증(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                            "시도할 회수는 몇회인가요?","실행 결과","pobi : -", "woni : -",
                            "pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD,MOVING_FORWARD
                ,MOVING_FORWARD,MOVING_FORWARD
        );

    }




    @Test
    void 횟수에_대한_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "jda"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 횟수에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", ""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 횟수에_대한_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,!@#sd,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
