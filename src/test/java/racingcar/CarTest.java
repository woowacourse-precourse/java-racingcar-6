package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import game.car.Car;
import game.car.CarList;
import game.car.CarName;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void CarName_이름이_5자초과인_경우_예외_발생() {
        assertThatThrownBy(() -> new CarName("dubibu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야 합니다.");
    }

    @Test
    void CarName_이름이_5자이하인_경우_객체_생성() {
        CarName carName = new CarName("dubib");

        assertThat(carName).hasFieldOrPropertyWithValue("carName", "dubib");
    }

    @Test
    void Car_이름이_올바를_경우_객체_생성() {
        Car car = new Car("dubib");
        assertThat(car.getCarName()).isEqualTo("dubib");
        assertThat(car).hasFieldOrPropertyWithValue("position", 0);
    }

    @Test
    void CarList_쉼표를_기준으로_잘못된_이름을_입력했을_경우_예외_발생() {

        assertThatThrownBy(() -> new CarList("pobi,woni,junnii"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야 합니다.");
    }

    @Test
    void CarList_쉼표를_기준으로_올바른_이름을_입력했을_경우_객체_생성() {
        CarList carList = new CarList("pobi,woni,junni");
        ArrayList<Car> carList1 = new ArrayList<>();
        carList1.add(new Car("pobi"));
        carList1.add(new Car("woni"));
        carList1.add(new Car("junni"));
        assertThat(carList).extracting("carList").asList().hasSize(3);
        assertThat(carList).extracting("carList").asList().usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(carList1);
    }
}
