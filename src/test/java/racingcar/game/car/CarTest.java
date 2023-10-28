package racingcar.game.car;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.engin.CarEngineV1;
import racingcar.game.inputgenerateManager.InputGenerateManager;

class CarTest {

    @Test
    void Car_객체_내부엔진이_각각_독립적인_객체인지_확인() {
        //if
        InputGenerateManager moveForwardValue = Mockito.mock(InputGenerateManager.class);
        Mockito.when(moveForwardValue.generateRandomInt()).thenReturn(4);

        InputGenerateManager stopValue = Mockito.mock(InputGenerateManager.class);
        Mockito.when(stopValue.generateRandomInt()).thenReturn(3);

        //when
        CarEngineV1 carEngineA = new CarEngineV1(moveForwardValue);
        Car carA = new Car("carA",carEngineA);
        carA.drive();

        CarEngineV1 carEngineB = new CarEngineV1(stopValue);
        Car carB = new Car("carB",carEngineB);
        carB.drive();

        //then
        Assertions.assertThat(carA.getForwardCount()).isEqualTo(1);
        Assertions.assertThat(carB.getForwardCount()).isEqualTo(0);
        Assertions.assertThat(carEngineA).isNotEqualTo(carEngineB);
    }

}