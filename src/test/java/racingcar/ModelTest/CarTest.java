package racingcar.ModelTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

public class CarTest {

    @Test
    @DisplayName("5글자 이상 유효성검사 테스트")
    public void validCarNameTest() {
        String invalidName = "genesis";
        String validName = "tico";

        assertThrows(IllegalArgumentException.class ,() -> new Car(invalidName));
        assertDoesNotThrow(() -> new Car(validName));
    }

    @Test
    @DisplayName("4이상일때 전진")
    public void moveTest() {
        int randomNumber = 4;
        Car car = new Car("test");
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하일때 멈춤")
    public void stopTest() {
        int randomNumber = 3;
        Car car = new Car("test");
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
