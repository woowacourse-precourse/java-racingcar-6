package racingcar.ModelTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Model.Cars;

public class CarsTest {

    @Test
    @DisplayName("최종승자 반환 테스트")
    public void getWinnersTest() {
        List<String> winners = List.of("0");
        Cars cars = new Cars();
        cars.addCar(new Car("0"));
        cars.addCar(new Car("1"));
        cars.addCar(new Car("2"));

        List<Car> carList = cars.getCars();
        carList.get(0).move(9);
        carList.get(0).move(9);

        assertThat(cars.getWinners()).isEqualTo(winners);
    }

}
