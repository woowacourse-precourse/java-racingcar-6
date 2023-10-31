package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerators.TestNumberGenerator;

class CarsTest {
    private Cars cars;
    private Car car1;
    private Car car2;
    private Car car3;
    private TestNumberGenerator movableNumberGenerator;

    @BeforeEach
    void setUp() {
        cars = new Cars("hot, fried, chick");

        movableNumberGenerator = new TestNumberGenerator(6);

        List<Car> carList = cars.getCars();

        car1 = carList.get(0);
        car2 = carList.get(1);
        car3 = carList.get(2);
    }

    @Test
    @DisplayName("단독 우승")
    void testSingleWinner() {
        car1.move(movableNumberGenerator);
        List<String> winnerList = cars.getWinnerCars();

        Assertions.assertThat(winnerList).containsExactly("hot");
    }

    @Test
    @DisplayName("공동 우승")
    void testMultipleWinner() {
        car1.move(movableNumberGenerator);
        car2.move(movableNumberGenerator);
        car3.move(movableNumberGenerator);
        List<String> winnerList = cars.getWinnerCars();

        Assertions.assertThat(winnerList).containsExactly("hot", "fried", "chick");
    }
}