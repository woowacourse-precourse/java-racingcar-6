package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자_출력_테스트() {
        OutputView outputView = new OutputView();
        List<String> winners = new ArrayList<>(List.of("woni, pobi"));

        outputView.printWinner(winners);
        assertThat(output()).isEqualTo("최종 우승자 : woni, pobi");
    }

    @Test
    void 경주_출력_확인_테스트1() {
        OutputView outputView = new OutputView();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("coni");
        car1.increaseForwardNum();
        car1.increaseForwardNum();
        List<Car> carList = new ArrayList<>(List.of(car1, car2, car3));

        assertRandomNumberInRangeTest(
                () -> {
                    outputView.printRacingResult(carList);
                    assertThat(output()).contains("pobi : --", "woni : ", "coni :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 경주_출력_확인_테스트2() {
        OutputView outputView = new OutputView();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car2.increaseForwardNum();
        car2.increaseForwardNum();
        List<Car> carList = new ArrayList<>(List.of(car1, car2));

        assertRandomNumberInRangeTest(
                () -> {
                    outputView.printRacingResult(carList);
                    assertThat(output()).contains("pobi : ", "woni : --");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
