package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Model.Car;
import racingcar.Model.CarsList;
import racingcar.Utils.GameConstants;

class CarTest {

    @DisplayName("자동차 이름 입력 시 ','기준으로 나누고 carsList에 저장")
    @Test
    void createCarsList() {
        CarsList carsList = new CarsList();
        List<Car> list;
        var text = "pobi,woni,jun";

        text = text.replace(" ", "");
        var texts = text.split(GameConstants.STRING_SPLIT_TEXT, -1);
        list = carsList.getCarsList(texts);

        assertThat(list.get(0).getName()).isEqualTo("pobi");
    }

    @DisplayName("자동차 이름 5글자 이상 시 예외 발생")
    @Test
    void inputCarNameOverFive() {
        CarsList carsList = new CarsList();
        var text = "pobiiii,woni,jun";

        text = text.replace(" ", "");
        var texts = text.split(GameConstants.STRING_SPLIT_TEXT, -1);

        assertThatThrownBy(() -> carsList.getCarsList(texts)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 입력 안할 시 예외 발생")
    @Test
    void inputCarNameIsNull() {
        CarsList carsList = new CarsList();
        var text = "";

        text = text.replace(" ", "");
        var texts = text.split(GameConstants.STRING_SPLIT_TEXT, -1);

        assertThatThrownBy(() -> carsList.getCarsList(texts)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("random숫자가 4~9사이면 자동차 움직임")
    void carMovable(int randomNum) {
        Car car = new Car("pobi", 0);

        car.move(randomNum);

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("random숫자가 1~3사이면 자동차 못 움직임")
    void carNotMovable(int randomNum) {
        Car car = new Car("pobi", 0);

        car.move(randomNum);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}