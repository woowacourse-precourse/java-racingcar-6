package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

import java.util.stream.Collectors;

class CarsTest {
    @ParameterizedTest(name="[{index}] 중복된 자동차 이름({0}) 예외 발생")
    @ValueSource(strings = {"car1,car2,car1", "car2,car2", "3,3"})
    void 중복_자동차_이름_예외_발생(String value) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Cars(value));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.CAR_NAME_DUPLICATE);
    }

    @ParameterizedTest(name="[입력받은 이름으로 자동차 리스트 생성")
    @ValueSource(strings = {"car1,car2,car3", "car2,car5", "1,2"})
    void 입력받은_이름으로_자동차_리스트_생성(String value) {
        // when
        Cars cars = new Cars(value);

        // then
        assertThat(cars.getCars()
                .stream()
                .map(c -> c.getName())
                .collect(Collectors.joining(",")))
                .isEqualTo(value);
    }

}