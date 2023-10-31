package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static ByteArrayOutputStream output = new ByteArrayOutputStream();

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
    void 자동차_입력받기() {
        String name = "test car";
        assertThat(name).isNotNull();
    }

    @Test
    void 구분자에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi@jun", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자에_대한_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi poly kevin solla", "3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 구분자에_대한_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobijunpoly", "2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Test
    void 시도_횟수_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("povi,jun", "five"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_횟수_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("povi,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도_횟수_예외_처리_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("povi,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시합_점수_초기화() {
        Application.InputCarName = "Car1,Car2,Car3";
        Application.Exception_Handling();

        assertThat(Application.RacingCar).contains("Car1", "Car2", "Car3");
        assertThat(Application.RacingScore).containsOnly(0);
    }

    @Test
    void 난수에_따른_전진_테스트() {
        Application.RacingCar = new LinkedList<>(Arrays.asList("Car1", "Car2"));
        Application.RacingScore = new LinkedList<>(Arrays.asList(0, 0));

        Application.Match_game();

        assertThat(Application.RacingScore)
                .allSatisfy(score -> assertThat(score).isGreaterThan(-1).isLessThan(2));
    }

    @Test
    void 이긴_자동차_고르기() {
        Application.RacingCar = new LinkedList<>(Arrays.asList("Car1", "Car2"));
        Application.RacingScore = new LinkedList<>(Arrays.asList(2, 5));

        Application.Racing_winner();

        assertThat(Application.Winner).contains("Car2");
    }

    @Test
    void 이긴_자동차_고르기_중복() {
        Application.RacingCar = new LinkedList<>(Arrays.asList("Car1", "Car2"));
        Application.RacingScore = new LinkedList<>(Arrays.asList(3, 3));

        Application.Racing_winner();

        assertThat(Application.Winner).contains("Car1", "Car2");
    }

    @Test
    void 우승자_출력_한명일때() {
        Application.InputCarName = "Car1, Car2, Car3";
        Application.Winner = new LinkedList<>();
        Application.Winner.add("Car2");

        System.setOut(new PrintStream(output));

        Application.Winner_Print();

        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : Car2");

        System.setOut(System.out);
    }

    @Test
    void 우승자_출력_여러명일때() {
        Application.InputCarName = "Car1, Car2, Car3";
        Application.Winner = new LinkedList<>();
        Application.Winner.add("Car2");
        Application.Winner.add("Car3");

        System.setOut(new PrintStream(output));

        Application.Winner_Print();

        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : Car2, Car3");

        System.setOut(System.out);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
