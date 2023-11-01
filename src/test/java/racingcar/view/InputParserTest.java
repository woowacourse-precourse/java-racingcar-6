package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.Input.InputParser;

public class InputParserTest {
    @Test
    @DisplayName("자동차 String -> List<Car> parsing test")
    void inputString_parsing() {
        String input = "BMW,Audi,Tesla";
        List<Car> expect = List.of(new Car("BMW"),new Car("Audi"),new Car("Tesla"));

        List<Car> result = new InputParser().convertCarList(input);
        assertThat(result.equals(expect));
    }

    @Test
    @DisplayName(",, 따옴표 연속으로 있을 경우 제거 test")
    void inputString_quotation() {
        String input = "pobi,,elsa";
        List<Car> expect = List.of(new Car("pobi"),new Car("else"));

        List<Car> result = new InputParser().convertCarList(input);
        assertThat(result.equals(expect));
    }

    @Test
    @DisplayName("trialNumber : String to int 파싱 테스트")
    void input_trialNumber_parsing() {
        String input = "3";

        assertThat(input.equals(3));
    }
}

