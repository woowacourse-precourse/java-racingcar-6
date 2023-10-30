package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private Referee referee = new Referee();
    @Test
    @DisplayName("우승자가 여러명인 경우 테스트")
    void testMultipleWinners() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("dobi", 4);
        Car car2 = new Car("pobi", 4);
        Car car3 = new Car("apple", 3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Cars carList = new Cars(cars);

        //예상되는 우승자 지정
        List<String> result = new ArrayList<>();
        result.add("dobi");
        result.add("pobi");

        Assertions.assertThat(referee.checkResult(carList)).isEqualTo(result);
    }

    @Test
    @DisplayName("우승자가 한 명인 경우 테스트")
    void testSingleWinner() {
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("dobi", 4);
        Car car2 = new Car("pobi", 2);
        Car car3 = new Car("apple", 3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Cars carList = new Cars(cars);

        //예상되는 우승자 지정
        List<String> result = new ArrayList<>();
        result.add("dobi");

        Assertions.assertThat(referee.checkResult(carList)).isEqualTo(result);
    }
}