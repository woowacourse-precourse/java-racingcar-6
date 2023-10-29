package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.driver.Driver;
import racingcar.domain.driver.RandomDriver;
import racingcar.vo.CarName;
import racingcar.vo.RoundCount;

class RacingTest {
    private static final Driver randomDriver = new RandomDriver();
    @Test
    void 경주에_사용할_자동차들을_생성한다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"), new CarName("woni"));
        List<Car> carList = getCarListByNames(carNameList);
        RoundCount roundCount = new RoundCount(5);
        // when
        Racing racing = new Racing(carList, roundCount);
        // then
        assertThat(racing).isNotNull();
    }

    private static List<Car> getCarListByNames(List<CarName> carNameList) {
        return carNameList.stream().map(name -> new Car(name, randomDriver)).toList();
    }

    @Test
    void 자동차가_2대_미만일_경우_예외를_발생시킨다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"));
        List<Car> carList = getCarListByNames(carNameList);
        RoundCount roundCount = new RoundCount(5);
        // when
        // then
        assertThatThrownBy(() -> new Racing(carList, roundCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 2대 이상이어야 합니다.");
    }

}