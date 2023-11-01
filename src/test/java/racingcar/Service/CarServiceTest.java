package racingcar.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

    CarService car ;

    @BeforeEach
    public void init() {
        car=new CarService();
    }
    @Test
    @DisplayName("각 시도당 0~9범위의 값을 구하는 기능")
    public void car1() {


        Assertions.assertThat(car.generateRandomNum()).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤값이 4 이상이면 전진하고 4미만이면 멈추는 기능.")
    public void car2() {
        int num=5;
        car.setGeneratedNum(num);
        Assertions.assertThat(car.forwardOrStop()).isTrue();

    }
}
