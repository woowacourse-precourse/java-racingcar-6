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

    private final Rule rule = new Rule();
    private final List<String> NAME_LIST = Arrays.asList("한놈", "두식이", "석삼", "너구리");
    private final String RACE_POINT = "----";
    private final Car CAR_A = Mockito.mock(Car.class);
    private final Car CAR_B = Mockito.mock(Car.class);
    private final Car CAR_C = Mockito.mock(Car.class);
    private final Car CAR_D = Mockito.mock(Car.class);
    private final List<Car> CAR_LIST = Arrays.asList(CAR_A, CAR_B, CAR_C, CAR_D);

    @BeforeEach
    public void setCars(){
        Mockito.when(CAR_A.getName()).thenReturn(NAME_LIST.get(0));
        Mockito.when(CAR_A.getForwardCount()).thenReturn(1);
        Mockito.when(CAR_B.getName()).thenReturn(NAME_LIST.get(1));
        Mockito.when(CAR_B.getForwardCount()).thenReturn(2);
        Mockito.when(CAR_C.getName()).thenReturn(NAME_LIST.get(2));
        Mockito.when(CAR_C.getForwardCount()).thenReturn(2);
        Mockito.when(CAR_D.getName()).thenReturn(NAME_LIST.get(3));
        Mockito.when(CAR_D.getForwardCount()).thenReturn(3);
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
        List<Car> winnerList = rule.findWinners(CAR_LIST);

        //then
        Assertions.assertThat(winnerList.get(0).getName()).isEqualTo(NAME_LIST.get(3));
    }
}