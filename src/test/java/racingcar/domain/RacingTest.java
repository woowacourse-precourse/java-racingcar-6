package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.driver.Driver;
import racingcar.domain.driver.RandomDriver;
import racingcar.dto.CarDTO;
import racingcar.mock.TrueDriver;
import racingcar.vo.CarName;
import racingcar.vo.RoundCount;

class RacingTest {
    private static final Driver randomDriver = new RandomDriver();
    private static final Driver trueDriver = new TrueDriver();
    @Test
    void 경주에_사용할_자동차들을_생성한다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"), new CarName("woni"));
        List<Car> carList = getRandomCarListByNames(carNameList);
        RoundCount roundCount = new RoundCount(5);
        // when
        Racing racing = new Racing(carList, roundCount);
        // then
        assertThat(racing).isNotNull();
    }

    private static List<Car> getRandomCarListByNames(List<CarName> carNameList) {
        return carNameList.stream().map(name -> new Car(name, randomDriver)).toList();
    }

    private static List<Car> getMoveCarListByNames(List<CarName> carNameList) {
        return carNameList.stream().map(name -> new Car(name, trueDriver)).toList();
    }

    @Test
    void 자동차가_2대_미만일_경우_예외를_발생시킨다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"));
        List<Car> carList = getRandomCarListByNames(carNameList);
        RoundCount roundCount = new RoundCount(5);
        // when
        // then
        assertThatThrownBy(() -> new Racing(carList, roundCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 2대 이상이어야 합니다.");
    }

    @Test
    void 이동_결과를_반환한다() {
        // given
        List<CarName> carNameList = List.of(new CarName("pobi"), new CarName("woni"));
        List<Car> carList = getMoveCarListByNames(carNameList);
        RoundCount roundCount = new RoundCount(5);
        Racing racing = new Racing(carList, roundCount);
        // when
        List<CarDTO> carDTOList = racing.round();
        // then
        assertThat(carDTOList.size()).isEqualTo(2);
        assertThat(carDTOList.stream().map(CarDTO::getPosition).toList()).containsExactly(1, 1);
    }
}