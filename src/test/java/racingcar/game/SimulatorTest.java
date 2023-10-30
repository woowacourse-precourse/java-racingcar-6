package racingcar.game;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class SimulatorTest {

    @Test
    void 라운드_반복시_값확인() {
        //if
        List<String> racingCarNameList = Arrays.asList("한놈", "두식이", "석삼", "너구리");
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        CarFactory carFactory = new CarFactory(mockInputGenerateManager);
        Mockito.when(mockInputGenerateManager.generateRandomInt())
                .thenReturn(4, 3, 4, 2)
                .thenReturn(2, 4, 3, 4)
                .thenReturn(4, 2, 4, 3)
                .thenReturn(3, 4, 2, 4)
                .thenReturn(4, 3, 1, 2);

        //when
        Simulator simulator = new Simulator();
        List<Car> cars = carFactory.createCars(racingCarNameList);
        for (int i = 0; i < 5; i++) {
            simulator.perRound(cars);
        }

        //then
        Assertions.assertThat(cars.get(0).getForwardCount()).isEqualTo(3);
        Assertions.assertThat(cars.get(1).getForwardCount()).isEqualTo(2);
        Assertions.assertThat(cars.get(2).getForwardCount()).isEqualTo(2);
        Assertions.assertThat(cars.get(3).getForwardCount()).isEqualTo(2);
    }
}