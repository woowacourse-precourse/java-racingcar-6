package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

class ConverterTest {
    @Test
    void 자동차_이름_문자열을_Cars_객체로_변환한다() {
        String carNames = "pobi,woni,jun";
        Cars cars = Converter.parseCarNames(carNames);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차의_이름이_다섯_글자_초과인_경우_예외를_발생한다() {
        String carNames = "pobiwoni";
        assertThatThrownBy(() -> Converter.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다");
    }

    @Test
    void 자동차_경주_단건_실행_결과를_변환한다() {
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Cars cars = new Cars(carList);
        String result = Converter.formatCarsResult(cars);
        assertAll(
                () -> assertThat(result).contains("pobi : "),
                () -> assertThat(result).contains("woni : "),
                () -> assertThat(result).contains("jun : ")
        );
    }

    @Test
    void 자동차_경주_우승자를_변환한다() {
        List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        Cars winners = new Cars(carList);
        String result = Converter.formatWinnersResult(winners);
        assertThat(result).isEqualTo("pobi, woni, jun");
    }
}