package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constants.ErrorConstants.*;

class CarListConverterTest {

    @Test
    @DisplayName("자동차의 이름을 가진 문자열을 이용해서 자동차가 담긴 리스트로 변환할 수 있다.")
    public void convertStringArrayToCarList() {
        // given
        String[] names = new String[]{"pobi","woni","jun"};
        // when
        List<Car> cars = CarListConverter.convertStringArrayToCarList(names);
        // then
        assertThat(cars).hasSize(3)
                .extracting("name")
                .containsOnly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("중복된 자동차의 이름을 제거되어 리스트로 변환된다.")
    public void convertDistinctTest() {
        // given
        String[] names = new String[]{"pobi","pobi","pobi"};
        // when
        List<Car> cars = CarListConverter.convertStringArrayToCarList(names);
        // then
        assertThat(cars).hasSize(1)
                .extracting("name")
                .containsOnly("pobi");
    }

    @Test
    @DisplayName("중복된 자동차의 이름이 5글자를 초과할 경우 예외가 발생한다.")
    public void nameLengthExceptionTest() {
        // given
        String[] names = new String[]{"pobbbii","pobi","pobiii"};
        // when // then
        assertThatThrownBy(() -> CarListConverter.convertStringArrayToCarList(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ERROR_MESSAGE);
    }

}