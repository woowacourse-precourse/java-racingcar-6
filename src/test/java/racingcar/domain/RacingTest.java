package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    void 우승자_반환_기능_한명인_경우() {

        Racing racing = new Racing();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        racing.addCar(car1);
        racing.addCar(car2);

        car1.moves(9);

        Assertions.assertThat(car1).isEqualTo(racing.getWinners().get(0));
    }

    @Test
    void 우승자_반환_기능_여러명인_경우() {
        Racing racing = new Racing();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        racing.addCar(car1);
        racing.addCar(car2);
        racing.addCar(car3);

        car1.moves(9);
        car2.moves(9);

        Assertions.assertThat(racing.getWinners().size()).isEqualTo(2);
    }

    @Test
    void 가장_멀리_간_자동차_위치_찾기() {
        Racing racing = new Racing();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        racing.addCar(car1);
        racing.addCar(car2);

        car1.moves(9);

        Assertions.assertThat(racing.findMaxLocation()).isEqualTo(1);
    }

    @Test
    void 특정_위치에_있는_자동차_찾기_한개인_경우() {
        Racing racing = new Racing();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        racing.addCar(car1);
        racing.addCar(car2);

        car1.moves(9);

        Assertions.assertThat(racing.findSameLocationCars(1)).contains(car1);
    }


    @Test
    void 특정_위치에_있는_자동차_찾기_여러개인_경우() {
        Racing racing = new Racing();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        racing.addCar(car1);
        racing.addCar(car2);
        racing.addCar(car3);

        Assertions.assertThat(racing.findSameLocationCars(0)).contains(car1, car2, car3);
    }

    @Test
    void 특정_위치에_있는_자동차_찾기_존재하지_않는_경우() {
        Racing racing = new Racing();
        Car car1 = new Car("Car1");
        racing.addCar(car1);

        car1.moves(9);

        Assertions.assertThat(racing.findSameLocationCars(0).size()).isEqualTo(0);
    }


}
