package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameServerTest extends NsTest {

    @Test
    void 전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    String output = output();
                    assertThat(output).contains("이름을 입력", "시도할 회수", "실행 결과", "pobi : ---", "woni : ---", "최종 우승자 : pobi, woni");
                    assertThat(output).hasLineCount(14);
                },
                Rule.GO.value, Rule.GO.value, Rule.GO.value, Rule.GO.value, Rule.GO.value, Rule.GO.value
                );
    }

    @Test
    void 전진_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    String output = output();
                    assertThat(output).contains("이름을 입력", "시도할 회수", "실행 결과", "pobi : ---", "woni : ", "최종 우승자 : pobi");
                    assertThat(output).hasLineCount(14);
                },
                Rule.GO.value, Rule.STOP.value, Rule.GO.value, Rule.STOP.value, Rule.GO.value, Rule.STOP.value
        );
    }

    @Test
    void 이름의_길이가_1_미만일_경우_에러를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름의_길이가_5_초과일_경우_에러를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("wooteco", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_숫자가_아닐경우_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_음수일경우_예외를_던진다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}