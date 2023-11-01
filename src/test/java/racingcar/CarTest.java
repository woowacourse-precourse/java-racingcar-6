package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("4 이상의 숫자가 들어오면 전진하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    public void moveTest(int randomNumber, int result) {
        Car car = new Car("테스트");
        if (car.isMoreThanCondition(randomNumber)) {
            car.move();
        }
        assertThat(car.getDistance()).isEqualTo(result);
    }

    @DisplayName("이름이 5자를 넘으면 예외가 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"daheee", "huihui"})
    public void checkNameLengthTest(String name) {
        assertThatThrownBy(()->{
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
