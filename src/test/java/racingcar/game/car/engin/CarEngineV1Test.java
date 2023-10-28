package racingcar.game.car.engin;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.enums.CarMove;
import racingcar.game.inputgenerateManager.InputGenerateManager;

class CarEngineV1Test {

    @Test
    void 난수값이_4이상일때_MOVING_FORWARD_반환() {
        //if
        InputGenerateManager mockInputGenerateManager = Mockito.mock(InputGenerateManager.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt()).thenReturn(4);
        CarEngineV1 carEngine = new CarEngineV1(mockInputGenerateManager);

        //when
        CarMove accelerate = carEngine.operateEngine();

        //then
        Assertions.assertThat(accelerate).isEqualTo(CarMove.MOVING_FORWARD);
    }

    @Test
    void 난수값이_3이하일때_STOP_반환() {
        //if
        InputGenerateManager mockInputGenerateManager = Mockito.mock(InputGenerateManager.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt()).thenReturn(3);
        CarEngineV1 carEngine = new CarEngineV1(mockInputGenerateManager);

        //when
        CarMove accelerate = carEngine.operateEngine();

        //then
        Assertions.assertThat(accelerate).isEqualTo(CarMove.STOP);
    }
}