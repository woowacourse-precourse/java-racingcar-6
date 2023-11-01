package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Mock
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mock 초기화
        RacingGame racingGame = new RacingGame(randomNumberGenerator);
    }

    @DisplayName("[RacingGame] move() 테스트1")
    @Test
    void car_이동하기_테스트_랜덤숫자가_4이상일때() {
        // Given
        RandomNumberGenerator randomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
        Mockito.when(randomNumberGenerator.generateRandomNumber()).thenReturn(4,5,6,7,8,9);

        RacingGame racingGame = new RacingGame(randomNumberGenerator);

        Car car1 = new Car("woo");
        Car car2 = new Car("wa");
        Car car3 = new Car("6");
        List<Car> carList = List.of(car1, car2, car3);

        // When
        List<Car> updatedCarList = racingGame.move(carList);

        // Then
        assertThat(updatedCarList.get(0).getDistance()).isEqualTo(1);
        assertThat(updatedCarList.get(1).getDistance()).isEqualTo(1);
    }

    @DisplayName("[RacingGame] move() 테스트2")
    @Test
    void car_이동하기_테스트_랜덤숫자가_4미만일때() {
        // Given
        RandomNumberGenerator randomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
        Mockito.when(randomNumberGenerator.generateRandomNumber()).thenReturn(0, 1, 2, 3);

        RacingGame racingGame = new RacingGame(randomNumberGenerator);

        Car car1 = new Car("woo");
        Car car2 = new Car("wa");
        Car car3 = new Car("6");
        List<Car> carList = List.of(car1, car2, car3);

        // When
        List<Car> updatedCarList = racingGame.move(carList);

        // Then
        assertThat(updatedCarList.get(0).getDistance()).isEqualTo(0);
        assertThat(updatedCarList.get(1).getDistance()).isEqualTo(0);
    }


}