package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.GetWinner;
import racingcar.domain.Maker;

import java.util.*;

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
    @DisplayName("이름에 ,가 없으면 예외를 발생한다.")
    void inputNameTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름에 숫자가 입력되면 예외를 발생한다.")
    void inputNameTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도회수에 특수문자가 들어오면 예외를 발생한다.")
    void inputNameTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", ","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도회수에 문자가 들어오면 예외를 발생한다.")
    void inputNameTest5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력받은 선수를 이용해 Map 자료구조로 변환 후 순서대로 반환한다.")
    void createMapTest() {
        //given
        String input = "pobi,java";
        Maker maker = new Maker(input);

        //when
        Map<String, Integer> map = maker.makeMap();
        List<String> keyList = new ArrayList<>(map.keySet());

        //then
        assertThat(keyList).containsExactly("pobi", "java");
    }

    @Test
    @DisplayName("카운터의 값이 가장 큰 member를 반환한다.")
    void returnWinnerTest() {
        //given
        Map<String, Integer> map = new HashMap<>();
        map.put("pobi", 1);
        map.put("java", 0);

        //when
        String winner = GetWinner.winner(map);

        //then
        assertThat(winner).isEqualTo("pobi");
    }

    @Test
    @DisplayName("카운터의 값이 가장 큰 member가 두 명이면 모두 반환한다.")
    void returnWinnerTwoTest() {
        //given
        Map<String, Integer> map = new HashMap<>();
        map.put("pobi", 1);
        map.put("java", 1);

        //when
        String winner = GetWinner.winner(map);

        //then
        assertThat(winner).isEqualTo("pobi, java");
    }

    @Test
    @DisplayName("카운터의 값이 가장 큰 member가 세 명이면 모두 반환한다.")
    void returnWinnerThreeTest() {
        //given
        Map<String, Integer> map = new HashMap<>();
        map.put("pobi", 1);
        map.put("java", 1);
        map.put("woni", 1);

        //when
        String winner = GetWinner.winner(map);

        //then
        assertThat(winner).isEqualTo("pobi, java, woni");
    }





    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
