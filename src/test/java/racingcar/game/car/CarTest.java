package racingcar.game.car;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.engin.CarEngineV1;
import racingcar.game.inputgenerateManager.InputGenerateManager;

class CarTest {

    private final InputGenerateManager moveForwardValue = Mockito.mock(InputGenerateManager.class);


    @Test
    void CarEngine_GO_FORWARD_반환시_forwardCount_증가() {
        //if
        Mockito.when(moveForwardValue.generateRandomInt()).thenReturn(4);

        //when
        CarEngineV1 carEngineA = new CarEngineV1(moveForwardValue);
        Car carA = new Car("carA", carEngineA);
        carA.drive();

        //then
        Assertions.assertThat(carA.getForwardCount()).isEqualTo(1);
        Assertions.assertThat(carA.getName()).isEqualTo("carA");
    }

    @Test
    void CarEngine_STOP_반환시_forwardCount_증가안함() {
        //if
        Mockito.when(moveForwardValue.generateRandomInt()).thenReturn(1);

        //when
        CarEngineV1 carEngineA = new CarEngineV1(moveForwardValue);
        Car carA = new Car("carA", carEngineA);
        carA.drive();

        //then
        Assertions.assertThat(carA.getForwardCount()).isEqualTo(0);
        Assertions.assertThat(carA.getName()).isEqualTo("carA");
    }


}