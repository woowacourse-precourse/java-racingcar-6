package racingcar.game;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.RacingCar;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class racingSimulatorTest {

    @Test
    void nameToRacingCar() {
        //if
        List<String> racingCarNameList= Arrays.asList("한놈","두식이","석삼","너구리");
        InputGenerateManagerImpl inputGenerateManager = new InputGenerateManagerImpl();

        //when
        RacingSimulator racingSimulator = new RacingSimulator(inputGenerateManager);
        List<RacingCar> racingCars = racingSimulator.nameToRacingCar(racingCarNameList);

        //then
        Assertions.assertThat(racingCars).size().isEqualTo(racingCarNameList.size());
        Assertions.assertThat(racingCars.get(0).getName()).isEqualTo("한놈");
        Assertions.assertThat(racingCars.get(1).getName()).isEqualTo("두식이");
        Assertions.assertThat(racingCars.get(2).getName()).isEqualTo("석삼");
        Assertions.assertThat(racingCars.get(3).getName()).isEqualTo("너구리");
    }

    @Test
    void roundStart() {
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
        RacingSimulator racingSimulator = new RacingSimulator(mockInputGenerateManager);
        List<RacingCar> racingCars = racingSimulator.nameToRacingCar(racingCarNameList);
        racingSimulator.roundStart(racingCars,5);

        //then
        Assertions.assertThat(racingCars.get(0).getForwardCount()).isEqualTo(2);
        Assertions.assertThat(racingCars.get(1).getForwardCount()).isEqualTo(3);
        Assertions.assertThat(racingCars.get(2).getForwardCount()).isEqualTo(2);
        Assertions.assertThat(racingCars.get(3).getForwardCount()).isEqualTo(2);
    }
}