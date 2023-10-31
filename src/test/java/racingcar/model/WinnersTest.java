package racingcar.model;

import model.Car;
import model.Winners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * packageName    : racingcar.model
 * fileName       : WinnerTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class WinnersTest {

    @Test
    @DisplayName("우승자 1명일경우")
    void getWinner(){
        String test1 = "test1";
        String test2 = "test2";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(test1));
        Car car2 = new Car(test2);

        car2.goOrStop(6);
        cars.add(car2);

        Winners winners = new Winners(cars);

        assertEquals(1, winners.getNames().size());
        assertEquals(test2, winners.getNames().get(0));
    }

    @Test
    @DisplayName("우승자가 여러명일경우")
    void 공동_우승자() {
        String test1 = "test1";
        String test2 = "test2";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(test1));
        cars.add(new Car(test2));

        Winners winners = new Winners(cars);

        assertThat(winners.getNames()).contains(test1, test2);
    }

    @Test
    @DisplayName("최종 우승자에 대한 위치값 출력")
    void getMaxPositionForWinner() {
        List<Car> cars = new ArrayList<>();
        Car car = new Car("test1");
        car.goOrStop(6);
        car.goOrStop(6);
        cars.add(car);

        Winners winners = new Winners(cars);

        assertThat(winners.getMaxPosition(cars)).isEqualTo(2);
    }
}
