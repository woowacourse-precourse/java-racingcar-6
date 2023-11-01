package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Umpire;

public class GameTest extends NsTest {
    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받기() {
        Cars cars = new Cars();
        String input = "pobi,woni,jun";
        command(input);

        List<String> carNames = cars.inputCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 시도_횟수_입력받아_저장하기() {
        Attempt attempt = new Attempt();
        command("5");

        assertThatCode(() -> attempt.saveAttemptNumber()).doesNotThrowAnyException();
    }

    @Test
    void 아무도_움직이지_않았을_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : ", "woni : ", "pobi : ", "woni : ", "최종 우승자 :");
                },
                0, 0
        );
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        Umpire umpire = new Umpire(cars);

        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        cars.get(0).move();
        cars.get(1).move();

        String winnerResult = umpire.findWinner();

        assertEquals("pobi, woni", winnerResult);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
