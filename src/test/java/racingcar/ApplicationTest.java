package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Override
    public void runMain() {
        Application.main(new String[]{});
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

    @Test
    void calculateFinalDistance() {
        //given
        List<String> gameResult = new ArrayList<String>(Arrays.asList("--","","---"));

        //when
        int[] result = Application.calculateFinalDistance(gameResult);

        //then
        Assertions.assertThat(result).containsExactly(2,0,3);
    }

    @Test
    @DisplayName("judgeMaxNum 함수로 가장 멀리 간 거리를 알 수 있다")
    void judgeMaxNum() {
        //given
        int[] raceResult = {1,8,3};

        //when
        int result = Application.judgeMaxNum(raceResult);

        //then
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("judgeWinner 함수로 최종 우승자 출력")
    void judgeWinnerTest() {
        ByteArrayOutputStream printResult = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printResult));

        // gien
        int max = 3;
        List<String> racingcarList = new ArrayList<String>(Arrays.asList("yenie","wooni","abcd"));
        int[] distanceList = {3,3,1};

        //when
        Application.judgeWinner(max,racingcarList,distanceList);

        //then
        assertEquals("최종 우승자 : yenie, wooni", printResult.toString());

        System.setOut(System.out);
    }
}
