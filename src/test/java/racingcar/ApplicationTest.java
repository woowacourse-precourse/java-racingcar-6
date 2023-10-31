package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @AfterEach
    public void afterEach() {
        RacingCarController.setRacingCarList(new ArrayList<>());
        Console.close();
    }

    @Test
    void 이름_스플릿() {
        ByteArrayInputStream in = new ByteArrayInputStream("pobi,woni".getBytes());
        System.setIn(in);

        List<String> result = InputOutputInterface.listenCarName();
        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    void 레이싱카_등록() {
        RacingCarController.setRacingCarList(new ArrayList<>());
        RacingCar result = RacingCarController.registerRacingCar("포비");
        assertThat(result.getName()).isEqualTo("포비");
        assertThat(result.getLocation()).isEqualTo(0);
    }

    @Test
    void 이동횟수에_대한_예외_처리() {
        ByteArrayInputStream in = new ByteArrayInputStream("123abc".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputOutputInterface.listenMovingCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱카_출력() {
        RacingCar racingCar = new RacingCar("testCar", 4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputOutputInterface.printRacingCarInfo(racingCar);

        assertThat(out.toString()).contains("testCar : ----");
    }

    @Test
    void 우승자_찾기() {
        List<RacingCar> racingCarList = new ArrayList<>();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RacingCar first = new RacingCar("firstCar", 3);
        RacingCar second = new RacingCar("secondCar", 5);
        RacingCar third = new RacingCar("thirdCar", 5);
        racingCarList.add(first);
        racingCarList.add(second);
        racingCarList.add(third);

        RacingCarController.setRacingCarList(racingCarList);
        List<RacingCar> result = RacingCarController.findWinner();
        InputOutputInterface.printWinner(result);

        assertThat(out.toString()).contains("secondCar", "thirdCar");
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
