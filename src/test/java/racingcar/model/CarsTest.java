package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setup() {
        CarNames carNames = CarNames.create("pobi,wonni,jun");
        cars = Cars.createWithNames(carNames);
    }

    @Test
    public void 우승자_한명_테스트() {
        //when
        for (int i = 4; i < 10; i++) {
            cars.getCarForTest(0).moveOrStop(i);
            cars.getCarForTest(1).moveOrStop(i - 1);
            cars.getCarForTest(2).moveOrStop(i - 2);
        }

        //then
        assertThat(cars.getWinner())
                .isEqualTo(List.of(cars.getCarForTest(0).getName()));
    }

    @Test
    public void 우승자_두명_테스트() {
        //when
        for (int i = 1; i < 10; i++) {
            cars.getCarForTest(0).moveOrStop(i);
            cars.getCarForTest(1).moveOrStop(i);
            cars.getCarForTest(2).moveOrStop(i - 1);
        }

        //then
        assertThat(cars.getWinner())
                .isEqualTo(List.of(cars.getCarForTest(0).getName(), cars.getCarForTest(1).getName()));
    }
}
