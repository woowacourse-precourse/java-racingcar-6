package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    void random_test() {
        assertThat(Application.random()).isBetween(0, 9);
    }

    @Test
    void situationRepeat_test() {
        List<String> name = Arrays.asList("jokyo");
        int[] goSituation = {0};
        int time = 3;
        int[][] Anser = {{0}, {1}, {2}, {3}};
        assertThat(Application.situationRepeat(name, goSituation, time)).isIn((Object[]) Anser);
    }

    @Test
    void situationPrint_test() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        List<String> name = Arrays.asList("povi", "jokyo");
        int[] goSituation = {1, 2};
        int i = 1;
        Application.situationPrint(name, goSituation, i);
        String console = outputStream.toString();
        assertThat(console).isIn("jokyo : --\n", "jokyo : ---\n");
        System.setOut(System.out);
    }

    @Test
    void situationSave_test() {
        int goSituation = 1;
        int i = 4;
        Assertions.assertEquals(2, Application.situationSave(goSituation, i));
    }

    @Test
    void bar_test() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        int i = 4;
        Application.bar(i);
        String console = outputStream.toString();
        Assertions.assertEquals("----\n", console);
        System.setOut(System.out);
    }

    @Test
    void judgeChampion_test() {
        int[] victory = {2, 4, 4};
        List<String> name = Arrays.asList("povi", "jagavi", "jokyo");
        Assertions.assertEquals("jagavi, jokyo", Application.judgeChampion(victory, name));
    }

    @Test
    void max_test() {
        int[] victory = {1, 5, 8, 4, 6};
        Assertions.assertEquals(8, Application.max(victory));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
