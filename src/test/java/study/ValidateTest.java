package study;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class ValidateTest {
    @Test
    void 자동차_이름_입력하지_않을_때_예외_발생() {
        Car kia = new Car("Kia", 0);
        Car honda = new Car("Honda", 0);
        Car porsche = new Car("Porsche", 0);
        Car blank = new Car("    ", 0);
        List<Car> cars = List.of(kia, honda, porsche, blank);

//        assertThatThrownBy(() -> InputView.validateCarNameNotEmpty(cars))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(Exception.CAR_NAME_NOT_EMPTY.name());
    }

    @Test
    void 문자_정규표현식_위반할_때_예외_발생() {
        String input = "Kia, Honda, Porsche, @@";
//        assertThatThrownBy(() -> InputView.parseCarNames(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(Exception.INVALID_CHARACTER_FORMAT.getMessage());
    }
}
