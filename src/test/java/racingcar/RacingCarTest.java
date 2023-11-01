package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import static util.RacingCarTestUtil.moveCar;
import static util.RacingCarTestUtil.setAlwaysCarMoveRule;
import static util.RacingCarTestUtil.setAlwaysCarStopRule;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.result.RaceResult;
import racingcar.view.ResultView;

/**
 * <p>docs/README.md
 * <h2>요구사항 1
 * <p>1-1. 자동차 전진 또는 정지
 * <p>1-2. 주어진 횟수만큼 반복하고 경주 진행 과정 출력
 */
class RacingCarTest extends NsTest {

    @Test
    void 자동차_전진() {
        // given
        /* 항상 전진하는 규칙 적용 */
        setAlwaysCarMoveRule();

        Car car = Car.from("zeus");

        int expected = 5;

        // when
        IntStream.range(0, expected).forEach(i -> car.goOrStop());
        int actual = car.getDistance();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차_정지() {
        // given
        /* 항상 정지하는 규칙 적용 */
        setAlwaysCarStopRule();

        Car car = Car.from("zeus");

        int expected = 0;

        // when
        IntStream.range(0, 5).forEach(i -> car.goOrStop());
        int actual = car.getDistance();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 경주_과정_출력() {
        // given
        /* 항상 전진하는 규칙 적용 */
        setAlwaysCarMoveRule();

        Car zeus = Car.from("zeus");
        Car blue = Car.from("blue");
        Car wonny = Car.from("wonny");
        Cars cars = Cars.from(List.of(zeus, blue, wonny));

        /* zeus는 3칸, blue는 1칸, wonny는 2칸 이동해 zeus 우승 */
        moveCar(zeus, 3);
        moveCar(blue, 1);
        moveCar(wonny, 2);

        RaceResult result = RaceResult.create();
        result.captureCars(cars);

        String expected = """
                zeus : ---
                blue : -
                wonny : --""";

        // when
        ResultView resultView = new ResultView();
        resultView.printResult(result);

        // then
        assertThat(output()).contains(expected);
    }


    @Override
    protected void runMain() {
    }
}
