package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("입력값 구분 후 데이터 초기화")
    void splitStringAndDataInit() {
        RacingList racingList = new RacingList();
        racingList.createData("aaa,bbb,ccc");
        LinkedHashMap<String, Integer> compareValue = new LinkedHashMap<>();
        compareValue.put("aaa", 0);
        compareValue.put("bbb", 0);
        compareValue.put("ccc", 0);
        assertThat(racingList.getCarList()).isEqualTo(compareValue);
    }

    @Test
    @DisplayName("자동차 입력 값 길이 제한 초과")
    void inputSizeValidate() {
        RacingList racingList = new RacingList();
        assertThrows(IllegalArgumentException.class, () -> racingList.createData("aaa,bbb,cccccc"));
    }

    @Test
    @DisplayName("자동차 이름 중복 입력")
    void inputDuplicateValidate() {
        RacingList racingList = new RacingList();
        assertThrows(IllegalArgumentException.class, () -> racingList.createData("aaa,bbb,aaa"));
    }

    @Test
    @DisplayName("공동 우승")
    void joint_winners() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("상태 값 출력 테스트")
    void statePrint() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("시도 횟수 입력 예외 처리 검증")
    void countValidate() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "null"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    @DisplayName("차 이름 중복 입력")
    void duplicateTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
