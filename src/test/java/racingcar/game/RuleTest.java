package racingcar.game;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.car.CarFactory;
import racingcar.game.director.Rule;
import racingcar.game.director.Simulator;
import racingcar.game.inputgenerateManager.InputGenerateManagerImpl;

class RuleTest {

    @Test
    void 자동차_반복횟수마다_하이픈_추가() {
        //if
        Rule rule = new Rule();
        Car mockCar = Mockito.mock(Car.class);
        Mockito.when(mockCar.getForwardCount())
                .thenReturn(4);

        //when
        String racingSituation = rule.countToHyphen(mockCar);

        //then
        Assertions.assertThat(racingSituation).isEqualTo("----");
    }

    @Test
    void 우승자_확인() {
        //if
        Rule rule = new Rule();
        List<String> racingCarNameList = Arrays.asList("한놈", "두식이", "석삼", "너구리");
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        CarFactory carFactory = new CarFactory(mockInputGenerateManager);
        Mockito.when(mockInputGenerateManager.generateRandomInt())
                .thenReturn(4, 4, 4, 2)
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
        List<Car> winnerList = rule.findWinners(cars);

        //then
        Assertions.assertThat(winnerList.get(0).getName()).isEqualTo("한놈");
        Assertions.assertThat(winnerList.get(1).getName()).isEqualTo("두식이");

    }

    @Test
    void 우승자_스트링_변환() {
        //if
        Rule rule = new Rule();
        List<String> racingCarNameList = Arrays.asList("한놈", "두식이", "석삼", "너구리");
        InputGenerateManagerImpl mockInputGenerateManager = Mockito.mock(InputGenerateManagerImpl.class);
        CarFactory carFactory = new CarFactory(mockInputGenerateManager);
        Mockito.when(mockInputGenerateManager.generateRandomInt())
                .thenReturn(4, 4, 4, 2)
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
        List<Car> winnerList = rule.findWinners(cars);
        String winnerListToString = rule.winnersToString(winnerList);

        //then
        Assertions.assertThat(winnerListToString).isEqualTo("한놈, 두식이");

    }
}