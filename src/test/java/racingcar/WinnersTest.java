package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import static util.RacingCarTestUtil.moveCar;
import static util.RacingCarTestUtil.setAlwaysCarMoveRule;

import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.model.car.Car;
import racingcar.model.car.CarName;
import racingcar.model.car.Cars;
import racingcar.model.race.result.RaceResult;
import racingcar.model.winner.Winners;
import racingcar.view.ResultView;

/**
 * <p>docs/README.md
 * <h2>요구사항 4
 * <p>4-1. 자동차별로 전진한 거리를 비교해 우승자 결정
 * <p>4-2. 우승자 출력
 */
class WinnersTest extends NsTest {

    @Test
    void 우승자_결정() {
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

        List<CarName> expected = List.of(zeus.getCarName());

        // when
        List<CarName> actual = Winners.from(result).stream().toList();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 우승자_결과_출력() {
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
        Winners winners = Winners.from(result);

        String expected = "최종 우승자 : zeus";

        // when
        ResultView resultView = new ResultView();
        resultView.printWinners(winners);

        // then
        assertThat(output()).contains(expected);
    }

    @Override
    protected void runMain() {
    }
}
