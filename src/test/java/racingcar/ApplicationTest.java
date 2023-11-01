package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGame;

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
    void 전진_정지_5라운드() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,철수,pobi2", "5");
                    assertThat(output()).contains("pobi : --", "철수 : -", "pobi2 : --", "최종 우승자 : pobi,pobi2");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_이름_확인() {
        String name = "pobi";
        RacingCar car = new RacingCar(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingCar racingCar = new RacingCar("test");
                    racingCar.goOrStop();
                    assertThat(racingCar.distance).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingCar racingCar = new RacingCar("test");
                    racingCar.goOrStop();
                    assertThat(racingCar.distance).isEqualTo(0);
                },
                STOP
        );
    }

    @Test
    void 자동차_이름_거리_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingCar racingCar = new RacingCar("pobi");
                    racingCar.goOrStop();
                    racingCar.printDistance();
                    assertThat(output()).contains("pobi : -");
                },
                MOVING_FORWARD
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
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_객체_생성() {
        RacingCarGame racingCarGame = new RacingCarGame(new Player());
        List<String> testNames = new ArrayList<>();
        testNames.add("pobi");
        testNames.add("june");
        List<RacingCar> cars = racingCarGame.createRacingCars(testNames);
        assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    void 자동차_게임_라운드_시작_및_결과_출력() {
        RacingCarGame racingCarGame = new RacingCarGame(new Player());
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("abc"));
        cars.add(new RacingCar("def"));
        racingCarGame.startGameRounds(cars, 3);
        assertThat(output()).contains("abc : ", "def : ");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
