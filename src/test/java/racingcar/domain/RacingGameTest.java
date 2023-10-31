package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("unmodifiableList인 경우에는 리스트에 값을 추가할 수 없습니다.")
    public void unmodifiableListTest() {
        Cars cars = new Cars("a,b,c");
        List<Car> carList = cars.getCarList();
        assertThatThrownBy(() -> carList.add(new Car("d")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("unmodifiableList인 경우에는 리스트에 값을 제거할 수 없습니다.")
    public void unmodifiableListTest2() {
        Cars cars = new Cars("a,b,c");
        List<Car> carList = cars.getCarList();
        assertThatThrownBy(() -> carList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("modifiableList인 경우에는 리스트에 값을 추가할 수 있습니다.")
    public void modifiableListTest() {
        Cars cars = new Cars("a,b,c");
        List<Car> carList = cars.getModifiableCarList();
        carList.add(new Car("d"));
        assertThat(cars.getModifiableCarList().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("modifiableList인 경우에는 리스트에 값을 제거할 수 있습니다.")
    public void modifiableListTest2() {
        Cars cars = new Cars("a,b,c");
        List<Car> carList = cars.getModifiableCarList();
        carList.remove(0);
        assertThat(cars.getModifiableCarList().size()).isEqualTo(2);
    }
}