package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.driver.Driver;
import racingcar.domain.driver.RandomDriver;
import racingcar.mock.TrueDriver;

class CarsTest {
    private final Driver driver = new RandomDriver();
    private final Driver trueDriver = new TrueDriver();
    @Test
    void Cars_생성_성공_테스트() {
        // given
        List<Car> givenCars = List.of(new Car(new CarName("pobi"), driver), new Car(new CarName("woni"), driver));
        // when
        Cars cars = new Cars(givenCars);
        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("Cars 생성 실패 테스트 - 자동차가 2대 미만일 경우")
    void validateMinimumCarsSize() {
        // given
        List<Car> givenCars = List.of(new Car(new CarName("pobi"), driver));
        // when
        // then
        assertThatThrownBy(() -> new Cars(givenCars))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 2대 이상이어야 합니다.");
    }

    @Test
    void moveAll() {
        // given
        Car pobi = new Car(new CarName("pobi"), trueDriver);
        Car woni = new Car(new CarName("woni"), trueDriver);
        List<Car> givenCars = List.of(pobi, woni);
        Cars cars = new Cars(givenCars);
        // when
        cars.moveAll();
        // then
        assertThat(pobi.getPosition()).isEqualTo(1);
        assertThat(woni.getPosition()).isEqualTo(1);
    }
}