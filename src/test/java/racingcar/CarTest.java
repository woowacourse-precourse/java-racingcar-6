package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자 생성 확인")
    public void generateRandomNumber() {
        Car car = new Car("test");
        int randomNumber = car.generateRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThan(10);
    }

    @Test
    @DisplayName("전진 확인")
    public void setProgress() {
        Car car = new Car("test");
        car.setProgress();
        assertThat(car.getProgress()).isEqualTo("-");
    }


}