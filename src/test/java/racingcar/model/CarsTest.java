package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static final List<String> CAR_LIST = new ArrayList<>(Arrays.asList("pobi", "woni", "blur"));
    Cars cars;

    @BeforeEach
    void reset() {
        cars = new Cars();
    }

    @Test
    @DisplayName("setCarsName 후 toString 출력 확인")
    void testSetCarsName() {
        cars.setCarsName(CAR_LIST);
        assertThat(cars.toString()).isEqualTo("pobi : \nwoni : \nblur : \n");
    }

    @Test
    @DisplayName("우승자 한명 일 경우 chooseWinner() 반환값 확인")
    void testChooseWinner() {
        //given
        List<Boolean> ifForwardList = new ArrayList<>(Arrays.asList(false, true, false));

        cars.setCarsName(CAR_LIST);
        cars.ifForwardCars(ifForwardList);

        //when
        String winner = cars.chooseWinner();

        assertThat(winner).isEqualTo("woni");
    }

    @Test
    @DisplayName("우승자 세 명 일 경우 chooseWinner() 반환값 확인")
    void testChooseThreeWinner() {
        //given
        List<Boolean> ifForwardList = new ArrayList<>(Arrays.asList(true, true, true));

        cars.setCarsName(CAR_LIST);
        cars.ifForwardCars(ifForwardList);

        //when
        String winner = cars.chooseWinner();

        assertThat(winner).isEqualTo("pobi, woni, blur");
    }
}