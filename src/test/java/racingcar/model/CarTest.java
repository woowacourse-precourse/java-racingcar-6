package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CarTest {

    @Test
    void 자동차_이름_Split_리스트_테스트() {
        Car car = new Car();
        String carsName = "dokgo,may,cat,uncle,king";

        assertThat(car.carsNameSplit(carsName)).containsExactly("dokgo", "may", "cat", "uncle", "king");
    }

    @Test
    void 자동차_Set_Get_테스트() {
        Car car = new Car();

        car.setCarName(List.of("dokgo", "may", "cat", "uncle", "king"));

        assertThat(car.getCarName()).isEquals("dokgo", "may", "cat", "uncle", "king");
    }
}
