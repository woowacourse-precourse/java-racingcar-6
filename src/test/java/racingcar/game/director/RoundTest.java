package racingcar.game.director;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;

class RoundTest {

    private final static List<String> NAME_LIST = Arrays.asList("한놈", "두식이", "석삼", "너구리");
    private List<Car> carList;
    private Car mockCarA;
    private Car mockCarB;
    private Car mockCarC;
    private Car mockCarD;

    @BeforeEach
    public void setCars() {
        mockCarA = Mockito.mock(Car.class);
        mockCarB = Mockito.mock(Car.class);
        mockCarC = Mockito.mock(Car.class);
        mockCarD = Mockito.mock(Car.class);
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
    void 리스트_넣고_라운드_반환() {
        //given
        Round round = new Round(carList);

        //when
        List<Car> findCarList = round.carList();

        //then
        Assertions.assertThat(findCarList.get(0)).isEqualTo(mockCarA);
        Assertions.assertThat(findCarList.get(1)).isEqualTo(mockCarB);
        Assertions.assertThat(findCarList.get(2)).isEqualTo(mockCarC);
        Assertions.assertThat(findCarList.get(3)).isEqualTo(mockCarD);
        Assertions.assertThat(findCarList.size()).isEqualTo(carList.size());

    }
}