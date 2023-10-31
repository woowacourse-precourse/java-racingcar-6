package racingcar.game;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.director.Rule;

class RuleTest {

    private final static Rule rule = new Rule();
    private final static List<String> NAME_LIST = Arrays.asList("한놈", "두식이", "석삼", "너구리");
    private final static String RACE_POINT = "----";
    private List<Car> carList;

    @BeforeEach
    public void setCars() {
        Car mockCarA = Mockito.mock(Car.class);
        Car mockCarB = Mockito.mock(Car.class);
        Car mockCarC = Mockito.mock(Car.class);
        Car mockCarD = Mockito.mock(Car.class);
        carList = Arrays.asList(mockCarA, mockCarB, mockCarC, mockCarD);

        Mockito.when(mockCarA.getName()).thenReturn(NAME_LIST.get(0));
        Mockito.when(mockCarA.getForwardCount()).thenReturn(1);
        Mockito.when(mockCarB.getName()).thenReturn(NAME_LIST.get(1));
        Mockito.when(mockCarB.getForwardCount()).thenReturn(2);
        Mockito.when(mockCarC.getName()).thenReturn(NAME_LIST.get(2));
        Mockito.when(mockCarC.getForwardCount()).thenReturn(2);
        Mockito.when(mockCarD.getName()).thenReturn(NAME_LIST.get(3));
        Mockito.when(mockCarD.getForwardCount()).thenReturn(3);
    }

    @Test
    void 자동차_반복횟수마다_하이픈_추가() {
        //if
        Car mockCar = Mockito.mock(Car.class);

        //when
        Mockito.when(mockCar.getForwardCount()).thenReturn(4);
        String racingSituation = rule.countToHyphen(mockCar);

        //then
        Assertions.assertThat(racingSituation).isEqualTo(RACE_POINT);
    }

    @Test
    void 우승자_확인() {
        //when
        List<Car> winnerList = rule.findWinners(carList);

        //then
        Assertions.assertThat(winnerList.get(0).getName()).isEqualTo(NAME_LIST.get(3));
    }
}