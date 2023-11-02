package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource({",0", "abcdef,0", "pobi,-1"})
    public void testCarConstruct(String name, int distance) {
        assertThatThrownBy(() -> new Car("", distance))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @CsvSource(value = {"0,pobi : ", "1,pobi : -", "4,pobi : ----"}, ignoreLeadingAndTrailingWhitespace = false)
    public void testCarToString(int distance, String expected) {
        Car pobiCar = new Car("pobi", distance);
        assertThat(pobiCar.toString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,pobi : ", "4,pobi : -", "9,pobi : -"}, ignoreLeadingAndTrailingWhitespace = false)
    public void testCarRandomForward(int randomNumber, String expected) {
        Car car = new Car("pobi", 0);
        car.forward((lowerBound, upperBound) -> randomNumber);
        assertThat(car.toString()).isEqualTo(expected);
    }
}
