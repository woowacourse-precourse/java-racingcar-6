package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void 이동_거리_출력_테스트(){
        Car car = new Car("test");
        Cars cars = new Cars();
        cars.add(car);

        car.move();

        assertThat(cars.getEachRoundResult()).isEqualTo("test : -\n");
    }

    @Test
    void 단독_우승자_출력_테스트() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");

        Cars cars = new Cars();
        cars.add(car1);
        cars.add(car2);

        car1.move();

        assertThat(cars.getWinner()).isEqualTo("test1");
    }

    @Test
    void 공동_우승자_출력_테스트() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");

        Cars cars = new Cars();
        cars.add(car1);
        cars.add(car2);

        car1.move();
        car2.move();

        assertThat(cars.getWinner()).isEqualTo("test1,test2");
    }
}