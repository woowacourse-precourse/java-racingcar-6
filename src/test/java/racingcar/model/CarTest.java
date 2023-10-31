package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.manager.model.Car;

public class CarTest {
    private final Car car = new Car();

    @Test
    void 차량이_들어온_수에_따라_멈추거나_이동하는_기능_테스트(){
        int randomNumber = 5;
        int expectedMoveCount = car.getMoveCount()+1;
        car.moveOrStop(randomNumber);
        assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);
    }

    @Test
    void 차_이름에_따라_이동거리_초기화_후_리스트_반환_테스트(){
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");

        List<Car> cars = car.getCarList(carNames);

        assertThat(cars).extracting("carName").contains("pobi", "woni", "jun");
        assertThat(cars).extracting("moveCount").containsOnly(0);
    }
}
