package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이름은 중복으로 사용될 수 없다.")
    @Test
    void isDifferentCarName() throws Exception {
        //given
        String racingCarName = "pobi";
        Car car = createCar(racingCarName, 0);

        List<Car> cars = List.of(car, car);

        //when //then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복으로 사용될 수 없습니다.");
    }

    @DisplayName("자동차경주를 하기위해 자동차는 최소 2대이상 생성해야합니다.")
    @Test
    void minimumCountOfCars() throws Exception {
        //given
        String racingCarName = "pobi";
        Car car = createCar(racingCarName, 0);

        List<Car> cars = List.of(car);

        //when //then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 2대 이상 생성해야 합니다.");
    }

    @DisplayName("자동차 경주 게임의 우승자를 확인할 수 있다.")
    @Test
    void findWinners() throws Exception {
        //given
        Car myCar = createCar("pobi", 3);
        Car competeCar1 = createCar("woni", 2);
        Car competeCar2 = createCar("jun", 3);
        Cars cars = new Cars(List.of(myCar, competeCar1, competeCar2));

        //when
        List<String> winners = cars.findWinners();

        //then
        Assertions.assertThat(winners).hasSize(2)
                .containsExactly("pobi", "jun");
    }

    private static Car createCar(String carName, int location) {
        return new Car(carName, location);
    }
}