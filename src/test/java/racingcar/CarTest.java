package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarTest {

    @Test
    @DisplayName("랜덤한 숫자가 4 이상일때 전진 테스트")
    void move_test(){
        Car car = new Car("jun", 0);
        GameManager gameManager = Mockito.mock(GameManager.class);
        car.gameManager = gameManager;

        when(gameManager.createRandomNumber()).thenReturn(4);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤한 숫자가 4 미만일때 정지 테스트")
    void stop_test(){
        Car car = new Car("jun", 1);
        GameManager gameManager = Mockito.mock(GameManager.class);
        car.gameManager = gameManager;

        when(gameManager.createRandomNumber()).thenReturn(3);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
