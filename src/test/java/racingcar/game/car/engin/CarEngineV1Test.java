package racingcar.game.car.engin;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.enums.CarMove;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class CarEngineV1Test {

    @Test
    void accelerateMovingForward() {
        //if
        InputGenerateManager mockInputGenerateManager = Mockito.mock(InputGenerateManager.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt()).thenReturn(4);
        CarEngineV1 carEngine = new CarEngineV1(mockInputGenerateManager);

        //when
        CarMove accelerate = carEngine.accelerate();

        //then
        Assertions.assertThat(accelerate).isEqualTo(CarMove.MOVING_FORWARD);
    }

    @Test
    void accelerateStop() {
        //if
        InputGenerateManager mockInputGenerateManager = Mockito.mock(InputGenerateManager.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt()).thenReturn(3);
        CarEngineV1 carEngine = new CarEngineV1(mockInputGenerateManager);

        //when
        CarMove accelerate = carEngine.accelerate();

        //then
        Assertions.assertThat(accelerate).isEqualTo(CarMove.STOP);
    }
}