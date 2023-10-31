package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private CarNames carNames;

    @BeforeEach
    public void setup() {
        carNames = CarNames.create("pobi,wonni,jun");
    }

    @Test
    public void 자동차들_생성() {
        //when
        Cars cars = Cars.createWithNames(carNames);
        List<String> carNameList = cars.getCars().stream().map(Car::getName).toList();

        //then
        List<String> expectedCarName = carNames.getCarNames().stream().map(CarName::getCarName).toList();
        assertThat(carNameList).isEqualTo(expectedCarName);
    }


    @Test
    public void 우승자_한명_테스트() {
        //given
        Cars cars = Cars.createWithNames(carNames);
        List<Car> carList = cars.getCars();

        //when
        for (int i = 4; i < 10; i++) {
            carList.get(0).moveOrStop(i);
            carList.get(1).moveOrStop(i - 1);
            carList.get(2).moveOrStop(i - 2);
        }

        //then
        assertThat(cars.getWinner())
                .isEqualTo(List.of(carList.get(0).getName()));
    }

    @Test
    public void 우승자_두명_테스트() {
        //given
        Cars cars = Cars.createWithNames(carNames);
        List<Car> carList = cars.getCars();

        //when
        for (int i = 1; i < 10; i++) {
            carList.get(0).moveOrStop(i);
            carList.get(1).moveOrStop(i);
            carList.get(2).moveOrStop(i - 1);
        }

        //then
        assertThat(cars.getWinner())
                .isEqualTo(List.of(carList.get(0).getName(), carList.get(1).getName()));
    }
}
