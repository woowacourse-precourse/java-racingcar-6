package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

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
        List<Car> cars = CarListConverter.convertCarNamesToCarList(names);
        // then
        assertThat(cars).hasSize(3)
                .extracting("name")
                .containsOnly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차의 이름이 중복될 경우 예외가 발생한다.")
    public void convertDuplicateExceptionTest() {
        // given
        String[] names = new String[]{"pobi","pobi","pobi"};
        // when // then
        assertThatThrownBy(() -> CarListConverter.convertCarNamesToCarList(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름이 5글자를 초과할 경우 예외가 발생한다.")
    public void convertNameLengthExceptionTest() {
        // given
        String[] names = new String[]{"pobbbii","pobi","pobiii"};
        // when // then
        assertThatThrownBy(() -> CarListConverter.convertCarNamesToCarList(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_ERROR_MESSAGE);
    }

}