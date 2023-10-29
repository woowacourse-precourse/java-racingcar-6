package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

public class CarTest {

    @DisplayName("4 이상의 숫자가 들어오면 전진하는 테스트")
    @Test
    @CsvSource(value = {"1:0", "3:0", "4:1", "5:1"}, delimiter = ',')
    public void moveTest(int randomNumber, int result) {
        Car car = new Car("테스트");
        if (car.isMoreThanCodition(randomNumber)) {
            car.move();
        }
        Assertions.assertThat(car.getDistance()).isEqualTo(result);
    }
}
