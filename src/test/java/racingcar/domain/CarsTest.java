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
}