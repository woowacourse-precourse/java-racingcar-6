package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.RacingCar;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

class RuleTest {

    @Test
    void countToHyphen() {
        //if
        Rule rule = new Rule();
        RacingCar mockRacingCar = Mockito.mock(RacingCar.class);
        Mockito.when(mockRacingCar.getForwardCount())
                .thenReturn(4);

        //when
        String racingSituation = rule.countToHyphen(mockRacingCar);

        //then
        Assertions.assertThat(racingSituation).isEqualTo("----");
    }

    @Test
    void callWinners() {
        //if
        Rule rule = new Rule();
        List<String> racingCarNameList = Arrays.asList("한놈","두식이","석삼","너구리");
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        Mockito.when(mockInputGenerateManager.generateRandomInt())
                .thenReturn(4,4,4,2)
                .thenReturn(2,4,3,4)
                .thenReturn(4,2,4,3)
                .thenReturn(3,4,2,4)
                .thenReturn(4,3,1,2);

        //when
        RacingSimulator racingSimulator = new RacingSimulator(mockInputGenerateManager);
        List<RacingCar> racingCars = racingSimulator.nameToRacingCar(racingCarNameList);
        racingSimulator.roundStart(racingCars,5);
        List<RacingCar> winnerList = rule.callWinners(racingCars);

        //then
        Assertions.assertThat(winnerList.get(0).getName()).isEqualTo("한놈");
        Assertions.assertThat(winnerList.get(1).getName()).isEqualTo("두식이");

    }
}