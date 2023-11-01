package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest extends NsTest {
    private static final int MOVING_FORWARD = 4;

    @Test
    void 우승자가_2명_이상일_경우_콤마로_구분하여_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    public void 모두_이동거리가_0일_경우_우승자는_없음() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        cars.add(new Car("car4"));

        // when
        GameManager gameManager = new GameManager();
        List<Car> winners = gameManager.getMaxDistanceCars(cars);

        // then
        assertThat(winners).hasSize(0);
    }

    @Test
    public void 가장_많이_이동한_참가자가_승리() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        cars.add(new Car("car4"));

        // when
        GameManager gameManager = new GameManager();
        cars.get(0).move(MOVING_FORWARD);
        List<Car> winners = gameManager.getMaxDistanceCars(cars);

        // then
        String assertedName = winners.get(0).getName();
        String expected = "car1";
        assertThat(assertedName).isEqualTo(expected);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
