package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputTest {

    @Test
    void inputCarNames_정상입력() {
        String input = "pobi,woni,jun";

        List<Car> result = Input.inputCarNames(input);

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getCarName()).isEqualTo(carList.get(0).getCarName());
        assertThat(result.get(1).getCarName()).isEqualTo(carList.get(1).getCarName());
        assertThat(result.get(2).getCarName()).isEqualTo(carList.get(2).getCarName());
    }

    @Test
    void inputCarNames_이름_5자_초과_예외() {
        assertThatThrownBy(() -> Input.inputCarNames("abc, banana"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputCarNames_이름_0자_예외() {
        assertThatThrownBy(() -> Input.inputCarNames("abc,,bbc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputCarNames_이름_공백_예외() {
        assertThatThrownBy(() -> Input.inputCarNames("abc,    ,bbc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryCount_정상입력() {
        String input = "5";

        int result = Input.inputTryCount(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void inputTryCount_타입_예외() {
        assertThatThrownBy(() -> Input.inputTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}