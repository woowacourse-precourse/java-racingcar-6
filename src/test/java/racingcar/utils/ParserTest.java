package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class ParserTest {
    @Test
    void 문자열을_자동차_리스트로_변환한다() {
        // given
        String name = "poby,woni,jun";
        List<Car> expected = List.of(
                Car.of("poby"),
                Car.of("woni"),
                Car.of("jun")
        );

        // when
        List<Car> actual = Parser.parseStringToCarList(name);

        // then
        assertThat(actual)
                .extracting(Car::getName)
                .containsExactlyElementsOf(expected.stream()
                        .map(Car::getName)
                        .toList());
    }

    @Test
    void 숫자로_이루어진_문자열을_정수로_변환한다() {
        // given
        String count = "5";
        Integer expected = 5;

        // when
        Integer actual = Parser.parseStringToInteger(count);

        // then
        assertThat(actual).isEqualTo(expected);
        assertThat(actual.getClass()).isEqualTo(Integer.class);
    }
}
