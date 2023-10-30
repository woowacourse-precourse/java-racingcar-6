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
    private final static Car CAR_A = Mockito.mock(Car.class);
    private final static Car CAR_B = Mockito.mock(Car.class);
    private final static Car CAR_C = Mockito.mock(Car.class);
    private final static Car CAR_D = Mockito.mock(Car.class);
    private final static List<Car> CAR_LIST = Arrays.asList(CAR_A, CAR_B, CAR_C, CAR_D);

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
    void 리스트_넣고_라운드_반환() {
        //if
        Round round = new Round(CAR_LIST);

        //when
        List<Car> findCarList = round.carList();

        //then
        Assertions.assertThat(findCarList.get(0)).isEqualTo(CAR_A);
        Assertions.assertThat(findCarList.get(1)).isEqualTo(CAR_B);
        Assertions.assertThat(findCarList.get(2)).isEqualTo(CAR_C);
        Assertions.assertThat(findCarList.get(3)).isEqualTo(CAR_D);
        Assertions.assertThat(findCarList.size()).isEqualTo(CAR_LIST.size());

    }
}