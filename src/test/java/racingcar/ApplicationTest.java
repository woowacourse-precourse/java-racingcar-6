package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 공동_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("love,peace", "4");
                    assertThat(output()).contains("최종 우승자 : love, peace");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD
        );
    }




    @Test
    void 단독_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("love,peace", "4");
                    assertThat(output()).contains("최종 우승자 : love");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP
        );
    }


    @Test
    void 우승자_추출() {
        // distance array , max 설정
        int[] distanceArray = new int[4];
        distanceArray[0] = 1;
        distanceArray[1] = 2;
        distanceArray[2] = 3;
        distanceArray[3] = 4;
        int max = 4;

        // getWinners 테스트
        ArrayList<Integer> array = Application.getWinners(distanceArray, max);

        // 예상값 index 3
        assertThat(array.get(0)).isEqualTo(3);
    }

    @Test
    void 최대값_추출() {
        // 최대값 5 설정
        int[] array = new int[3];
        array[0] = 5;
        array[1] = 3;
        array[2] = 2;

        // finmaxDistance 함수 테스트
        int max = Application.findMaxDistance(array);

        // 예상값 5
        assertThat(max).isEqualTo(5);

    }

    @Test
    void 레이싱_과정_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("love,peace", "4");
                    assertThat(output()).contains("love : ----", "peace : ");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP
        );
    }


    @Test
    void 시도_횟수_숫자_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("love,peace", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 자동차_이름_숫자영어_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("한글,입니다", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }


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
