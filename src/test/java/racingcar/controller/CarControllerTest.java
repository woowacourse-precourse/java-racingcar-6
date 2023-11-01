package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.util.RandomNumberGenerator;

class CarControllerTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator() {
        @Override
        public int generate() {
            return 5;
        }
    };
    CarManager carManager = new CarManager(randomNumberGenerator);
    @Test
    public void 초기_자동차_이름_위치_테스트() throws Exception {
        //given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        //when
        List<Car> cars = carManager.initializeCars(carNames);

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    public void 자동차_전진_테스트() throws Exception {

        //given
        List<Car> cars = Arrays.asList(new Car("car1", 0), new Car("car2", 0));

        //when
        carManager.moveCarForward(cars);

        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
    }

    @Test
    public void 우승자_찾기_테스트() throws Exception {
        //given
        List<Car> cars = Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 4),
                new Car("car3", 5),
                new Car("car4", 2)
        );
        //when
        List<Car> winners = carManager.findWinners(cars);

        //then
        assertThat(winners).hasSize(1);
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("car3");
    }

}