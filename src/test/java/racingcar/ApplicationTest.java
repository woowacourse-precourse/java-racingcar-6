package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import racingcar.domain.Racing;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private InputStream originalSystemIn;
    /*public InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }*/
    public Racing race2;

    @BeforeEach
    public void setup() {
        System.out.println("테스트를 시작합니다.");
        race2 = new Racing();
    }

    @AfterEach
    public void tearDown() {
        Console.close();
    }

    @Test
    void 이름은_쉼표로_구별() {
        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(("james,roman,jon\n").getBytes());
        System.setIn(inputStream1);

        List<String> expected = Arrays.asList("james", "roman", "jon");
        List<String> actual = race2.getCarNames();
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
        assertEquals(expected, actual);

    }

    @Test
    void 콤마_사이의_공백_무시() {
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(("james  ,  roman, jon\n").getBytes());
        System.setIn(inputStream2);

        List<String> expected = Arrays.asList("james", "roman", "jon");
        List<String> actual = race2.getCarNames();
        assertEquals(expected, actual);
    }

    @Test
    void 점수_초기화_확인() {
        ByteArrayInputStream inputStream3 = new ByteArrayInputStream(("james, roman, john\n").getBytes());
        System.setIn(inputStream3);

        race2.getCarNames();
        List<Integer> expected = Arrays.asList(0, 0, 0);
        List<Integer> actual = race2.initCarPoints();
        assertEquals(expected, actual);
    }

    @Test
    void 이름에_대한_예외_처리_6자_이상일_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 입력한_이동_회수에_대한_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("james,  joan,roman", "23a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 각_라운드_종료_후_실행_결과를_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,james", "2");
                    assertThat(output()).contains("pobi : ", "woni : -", "james : ", "pobi : -", "woni : --", "james : ");
                },
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 단일_우승자가_존재하는_경주_결과를_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : ", "woni : -", "최종 우승자 : woni");
                },
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 여러_우승자가_존재하는_경주_결과를_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
