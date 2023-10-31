package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import static racingcar.config.CarMoveRuleConfig.setCustomCarMoveRule;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.model.car.Car;
import racingcar.model.car.CarMoveRule;
import racingcar.model.car.CarName;
import racingcar.model.car.Cars;
import racingcar.model.race.result.RaceResult;
import racingcar.model.winner.Winners;
import racingcar.view.ResultView;

/**
 * docs/README.md <br/><br/> 요구사항 4 <br/><br/> 4-1. 자동차별로 전진한 거리를 비교해 우승자 결정 <br/> 4-2. 우승자 출력 <br/>
 */
class WinnersTest extends NsTest {

    @Test
    void 우승자_결정() {
        // given
        CarMoveRule alwaysGo = () -> true;
        setCustomCarMoveRule(alwaysGo);     // 100% 확률로 이동하도록 규칙 변경

        Car zeus = Car.from("zeus");
        Car blue = Car.from("blue");
        Car wonny = Car.from("wonny");
        Cars cars = Cars.from(List.of(zeus, blue, wonny));

        List<CarName> expected = List.of(zeus.getCarName());    // 항상 zeus 우승

        // when
        /* zeus는 3칸, blue는 1칸, wonny는 2칸 이동 */
        moveCar(zeus, 3);
        moveCar(blue, 1);
        moveCar(wonny, 2);

        RaceResult result = RaceResult.create();
        result.captureCars(cars);

        List<CarName> actual = Winners.from(result).stream().toList();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 우승자_결과_출력() {
        // given
        CarMoveRule alwaysMove = () -> true;
        setCustomCarMoveRule(alwaysMove);     // 100% 확률로 이동하도록 규칙 변경

        Car zeus = Car.from("zeus");
        Car blue = Car.from("blue");
        Car wonny = Car.from("wonny");
        Cars cars = Cars.from(List.of(zeus, blue, wonny));

        String expected = "최종 우승자 : zeus";

        // when
        /* zeus는 3칸, blue는 1칸, wonny는 2칸 이동 */
        moveCar(zeus, 3);
        moveCar(blue, 1);
        moveCar(wonny, 2);

        RaceResult result = RaceResult.create();
        result.captureCars(cars);
        Winners winners = Winners.from(result);

        ResultView resultView = new ResultView();
        resultView.printWinners(winners);

        // then
        assertThat(output()).contains(expected);
    }

    private void moveCar(Car car, int distance) {
        IntStream.range(0, distance).forEach(i -> car.goOrStop());
    }

    @Override
    protected void runMain() {
    }
}
