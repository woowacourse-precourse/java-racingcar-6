package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarGarageTest {

    @Test
    void 한명의_승자_테스트() {
        //given
        Car car1 = carFactory("name1");
        Car car2 = carFactory("name2");
        Car car3 = carFactory("name3");
        CarGarage carGarage = new CarGarage(List.of(
                car1, car2, car3
        ));

        car1.updatePositionBy(MoveCondition.MOVE);

        //when
        Winner winner = carGarage.findWinner();

        //then
        assertThat(winner.getValue().size()).isEqualTo(1);
        assertThat(winner.getValue()).containsExactly(car1);
    }

    @Test
    void 모두가_승자_테스트() {
        //given
        Car car1 = carFactory("name1");
        Car car2 = carFactory("name2");
        Car car3 = carFactory("name3");
        CarGarage carGarage = new CarGarage(List.of(
                car1, car2, car3
        ));

        car1.updatePositionBy(MoveCondition.MOVE);
        car2.updatePositionBy(MoveCondition.MOVE);
        car3.updatePositionBy(MoveCondition.MOVE);

        //when
        Winner winner = carGarage.findWinner();

        //then
        assertThat(winner.getValue().size()).isEqualTo(3);
        assertThat(winner.getValue()).containsExactly(car1, car2, car3);
    }

    static Car carFactory(String name) {
        return new Car(new Name(name));
    }
}
