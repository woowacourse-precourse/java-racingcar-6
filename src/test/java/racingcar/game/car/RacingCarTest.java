package racingcar.game.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.engin.CarEngineV1;
import racingcar.game.inputgenerateManager.InputGenerateManager;

class RacingCarTest {

    @Test
    void drive() {
        //if
        InputGenerateManager moveForwardValue = Mockito.mock(InputGenerateManager.class);
        Mockito.when(moveForwardValue.generateRandomInt()).thenReturn(4);

        InputGenerateManager stopValue = Mockito.mock(InputGenerateManager.class);
        Mockito.when(stopValue.generateRandomInt()).thenReturn(3);

        //when
        CarEngineV1 carEngineA = new CarEngineV1(moveForwardValue);
        RacingCar carA = new RacingCar(carEngineA);
        carA.drive();

        CarEngineV1 carEngineB = new CarEngineV1(stopValue);
        RacingCar carB = new RacingCar(carEngineB);
        carB.drive();

        //then
        Assertions.assertThat(carA.getForwardCount()).isEqualTo(1);
        Assertions.assertThat(carB.getForwardCount()).isEqualTo(0);
        Assertions.assertThat(carEngineA).isNotEqualTo(carEngineB);
    }
}