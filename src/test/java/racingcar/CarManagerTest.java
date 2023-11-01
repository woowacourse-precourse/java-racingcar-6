package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CarManagerTest {

    @DisplayName("최대 위치를 반환한다.")
    @Test
    void maxPosition() {
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("aaa",0);
        Car car3 = new Car("bbb",5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        CarManager carManager = new CarManager(cars);

        int maxPosition = carManager.maxPosition();

        Assertions.assertThat(maxPosition).isEqualTo(5);
    }


    @DisplayName("시도 횟수만큼 자동차를 이동시킨다.")
    @Test
    void attempt() {
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("aaa",0);
        Car car3 = new Car("bbb",5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        CarManager carManager = new CarManager(cars);
        int attempt = 5;

        carManager.attempt(attempt);

        //테스트 불가 의존성 역전 적용해야함
    }

    @DisplayName("승자를 가져온다.")
    @Test
    void winner() {
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("aaa",0);
        Car car3 = new Car("bbb",5);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        CarManager carManager = new CarManager(cars);

        List<Car> winner = carManager.winner(5);

        Assertions.assertThat(winner).contains(car3);
    }
}