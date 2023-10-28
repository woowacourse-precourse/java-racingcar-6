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
    void 이름으로_차량생성_테스트() {
        //if
        List<String> racingCarNameList= Arrays.asList("한놈","두식이","석삼","너구리");
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //when
        Simulator simulator = new Simulator(inputGenerateManager);
        List<Car> cars = simulator.nameToRacingCar(racingCarNameList);

        //then
        Assertions.assertThat(cars).size().isEqualTo(racingCarNameList.size());
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("한놈");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("두식이");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("석삼");
        Assertions.assertThat(cars.get(3).getName()).isEqualTo("너구리");
    }

    @Test
    void 라운드_반복시_값확인() {
        //if
        List<String> racingCarNameList = Arrays.asList("한놈","두식이","석삼","너구리");
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt())
                .thenReturn(4,3,4,2)
                .thenReturn(2,4,3,4)
                .thenReturn(4,2,4,3)
                .thenReturn(3,4,2,4)
                .thenReturn(4,3,1,2);

        //when
        Simulator simulator = new Simulator(mockInputGenerateManager);
        List<Car> cars = simulator.nameToRacingCar(racingCarNameList);
        for (int i=0; i<5;i++){
            simulator.perRound(cars);
        }

        //then
        Assertions.assertThat(cars.get(0).getForwardCount()).isEqualTo(3);
        Assertions.assertThat(cars.get(1).getForwardCount()).isEqualTo(2);
        Assertions.assertThat(cars.get(2).getForwardCount()).isEqualTo(2);
        Assertions.assertThat(cars.get(3).getForwardCount()).isEqualTo(2);
    }
}