package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @DisplayName("콤마로 이름을 구분하여 Car 객체를 만드는 테스트")
    @Test
    public void separateNameTest() {
        Cars cars = new Cars("dahee,hui,pobi");
        Car dahee = cars.getCar(0);
        Car hui = cars.getCar(1);
        Car pobi = cars.getCar(2);

        assertThat(dahee.getName()).isEqualTo("dahee");
        assertThat(hui.getName()).isEqualTo("hui");
        assertThat(pobi.getName()).isEqualTo("pobi");
    }

    @DisplayName("가장 많이 전진한 자동차 한 개를 찾는 테스트")
    @Test
    public void findWinnerTest() {
        Cars cars = new Cars("dahee,hui,pobi");
        Car dahee = cars.getCar(0);
        Car hui = cars.getCar(1);
        Car pobi = cars.getCar(2);

        dahee.move();
        List<String> winnerCar = cars.findLongDistanceCarsName();

        assertThat(winnerCar.get(0)).isEqualTo("dahee");
    }

    @DisplayName("가장 많이 전진한 자동차 두 개를 찾는 테스트")
    @Test
    public void findWinnersTest() {
        Cars cars = new Cars("dahee,hui,pobi");
        Car dahee = cars.getCar(0);
        Car hui = cars.getCar(1);
        Car pobi = cars.getCar(2);

        dahee.move();
        hui.move();
        List<String> winnerCar = cars.findLongDistanceCarsName();

        assertThat(winnerCar.get(0)).isEqualTo("dahee");
        assertThat(winnerCar.get(1)).isEqualTo("hui");
    }
}
