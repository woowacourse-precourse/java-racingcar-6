package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

class CarListTest {


    @Test
    void 자동차_이름_중복_테스트() {
        List<Car> cars = Arrays.asList(
                new Car("중복이름"),
                new Car("중복이름"));
        assertThatThrownBy(() -> new CarList(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_CAR_NAME_DUPLICATION);
    }

    @Test
    void 모든_자동차_전진_테스트() {
        List<Car> cars = Arrays.asList(
                new Car("povi"),
                new Car("woni"));

        CarList carList = new CarList(cars);
        List<Integer> carsPosition = carList.moveAllCars();
        assertThat(carsPosition).isNotNull();

    }

    @Test
    void 자동차_상태_출력() {
        List<Car> cars = Arrays.asList(new Car("povi"));
        assertThat(new CarList(cars).getCarsStatus()).contains("povi : ");
    }

    @Test
    void 우승자를_출력하는기능() {
        List<Car> cars = Arrays.asList(new Car("povi"));
        assertThat(new CarList(cars).getWinnerNames()).isEqualTo("povi");
    }


}