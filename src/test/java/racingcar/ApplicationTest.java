package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void 이름_처리() {
        String test = "테스트,입니다,안녕";
        List<String> cut = Application.nameCut(test);
        List<String> expected = new ArrayList<>(Arrays.asList("테스트", "입니다", "안녕"));
        Assertions.assertLinesMatch(expected, cut);
    }

    @Test
    void 초과_입력_예외() {
        String test = "여섯글자에용";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.nameLength(test));
    }

    @Test
    void 이름_입력_예외() {
        String[] test = {"예외가", "", "fddffd"};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.checkName(test));
    }

    @Test
    void 공백_입력_예외() {
        String test = "";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.nameNull(test));
    }

    @Test
    void 시간_변환() {
        String test = "1";
        Assertions.assertEquals(1, Application.integerTime(test));
    }
    @Test
    void 시간_숫자외_입력_예외() {
        String test = "5어시";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.timeIsNumber(test));
    }
    @Test
    void 시간_음수_입력_예외() {
        String test = "0";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.timeIsOver0(test));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
