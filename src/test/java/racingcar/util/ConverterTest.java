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
        Cars cars = Converter.parseCars("pobi,woni,jun");
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차의_이름이_다섯_글자_초과인_경우_예외를_발생한다() {
        assertThatThrownBy(() -> Converter.parseCars("pobiwoni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름을 5글자 이하로 입력해주세요");
    }

    @Test
    void 자동차의_이름이_한_글자_미만인_경우_예외를_발생한다() {
        assertThatThrownBy(() -> Converter.parseCars(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름을 1글자 이상 입력해주세요");
    }

    @Test
    void 자동차_경주_단건_실행_결과를_변환한다() {
        Cars cars = new Cars(
                List.of(new Car("pobi"), new Car("woni"), new Car("jun"))
        );
        String result = Converter.formatCarsResult(cars);
        assertAll(
                () -> assertThat(result).contains("pobi : "),
                () -> assertThat(result).contains("woni : "),
                () -> assertThat(result).contains("jun : ")
        );
    }

    @Test
    void 자동차_경주_우승자를_변환한다() {
        Cars winners = new Cars(
                List.of(new Car("pobi"), new Car("woni"), new Car("jun"))
        );
        String result = Converter.formatWinnersResult(winners);
        assertThat(result).isEqualTo("pobi, woni, jun");
    }
}