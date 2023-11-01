package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.driver.Driver;
import racingcar.domain.driver.RandomDriver;
import racingcar.dto.CarDTO;
import racingcar.mock.FalseDriver;
import racingcar.mock.TrueDriver;

class CarsTest {
    private final Driver driver = new RandomDriver();
    private final Driver trueDriver = new TrueDriver();
    private final Driver falseDriver = new FalseDriver();
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
    void 이동시_모든_자동차는_전진을_수행한다() {
        // given
        Car pobi = new Car(new CarName("pobi"), trueDriver);
        Car woni = new Car(new CarName("woni"), trueDriver);
        List<Car> givenCars = List.of(pobi, woni);
        Cars cars = new Cars(givenCars);
        // when
        cars.moveAll();
        // then
        assertThat(pobi.toDTO().getPosition()).isEqualTo(1);
        assertThat(woni.toDTO().getPosition()).isEqualTo(1);
    }

    @Test
    void 한명_이상의_우승자를_뽑는다() {
        // given
        Car pobi = new Car(new CarName("pobi"), trueDriver);
        Car woni = new Car(new CarName("woni"), trueDriver);
        Car stopCar1 = new Car(new CarName("stop1"), falseDriver);
        Car stopCar2 = new Car(new CarName("stop2"), falseDriver);
        Car stopCar3 = new Car(new CarName("stop3"), falseDriver);
        List<Car> givenCars = List.of(pobi, woni, stopCar1, stopCar2, stopCar3);
        Cars cars = new Cars(givenCars);
        // when
        cars.moveAll();
        List<CarDTO> maxPositionCars = cars.getMaxPositionCars();
        // then
        assertThat(maxPositionCars.size()).isEqualTo(2);
        assertThat(maxPositionCars.stream().map(CarDTO::getName).toList()).containsExactly("pobi", "woni");
    }

    @Test
    void 전부_같다면_모두_우승자이다(){
        // given
        Car pobi = new Car(new CarName("pobi"), trueDriver);
        Car woni = new Car(new CarName("woni"), trueDriver);
        // when
        List<Car> givenCars = List.of(pobi, woni);
        Cars cars = new Cars(givenCars);
        cars.moveAll();
        List<CarDTO> maxPositionCars = cars.getMaxPositionCars();
        // then
        assertThat(maxPositionCars.size()).isEqualTo(2);
    }
}