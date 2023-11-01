package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.play.Car;
import racingcar.play.Game;

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
    void 공동_우승자_처리() {
        Game game = new Game(Arrays.asList("kim", "go", "chan"), 5);

        game.cars.get(0).position = 3;
        game.cars.get(1).position = 3;
        game.cars.get(2).position = 2;

        List<String> winners = game.getWinners();

        assertThat(winners).containsExactly("kim", "go");
    }

    @Test
    void 정해진_횟수_달성시_종료() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("kim"));
        cars.add(new Car("go"));
        cars.add(new Car("chan"));

        cars.get(0).position = 1;
        cars.get(1).position = 2;
        cars.get(2).position = 3;

        Game game = new Game(Arrays.asList("kim", "go", "chan"), 5);

        game.play();

        assertThat(cars.get(0).getPosition()).isEqualTo(1); // Check Car1's position
        assertThat(cars.get(1).getPosition()).isEqualTo(2); // Check Car2's position
        assertThat(cars.get(2).getPosition()).isEqualTo(3); // Check Car3's position
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
