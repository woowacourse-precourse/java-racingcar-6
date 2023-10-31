package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

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
    void 세트마다_결과가_출력() {
        assertSimpleTest(() ->
                {
                    run("pobi,woni", "2");
                    assertThat(output().lines()
                            .filter(line -> line.startsWith("pobi :") || line.startsWith("woni :")).toList()
                            .size()
                    ).isEqualTo(4);
                }
        );
    }

    @Test
    void 세트가_진행될수록_전진도_누적() {
        assertSimpleTest(() ->
                {
                    run("pobi,woni", "3");
                    assertThat(output().lines()
                            .filter(line -> line.startsWith("pobi :"))
                            .map(String::length)
                            .collect(Collectors.toList())
                    ).isSorted();
                }
        );
    }

    @Test
    void 최종_결과_출력() {
        assertSimpleTest(() ->
                {
                    run("pobi,woni", "1");
                    List<String> result = output().lines().toList();
                    String winner;
                    if(result.get(3).length() == result.get(4).length())
                        winner = "pobi, woni";
                    else if(result.get(3).length() > result.get(4).length())
                        winner = "pobi";
                    else winner = "woni";

                    assertThat(result.get(6)).contains(winner);
                }
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
    void 중복된_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수가_1보다_작을시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수가_100보다_클시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hi", "101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
