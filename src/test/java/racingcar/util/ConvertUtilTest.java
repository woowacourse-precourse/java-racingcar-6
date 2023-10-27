package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ConvertUtilTest {

    @Test
    @DisplayName("입력된 이름만큼 동일한 이름을 가진 Car 객체가 만들어져야 한다")
    void test_convertStrToListCar() throws Exception {

        //given
        String carNames = "one,two,three";

        //when
        List<Car> cars = ConvertUtil.convertStrToListCar(carNames);

        //then
        assertEquals(cars.get(0).getName(), "one");
        assertEquals(cars.get(1).getName(), "two");
        assertEquals(cars.get(2).getName(), "three");
    }

    @Test
    @DisplayName("입력된 숫자만큼 - 가 출력되어야한다")
    void test_convertPositionToStr() throws Exception {

        //given
        int position1 = 3;
        int position2 = 4;

        //when
        String toStr1 = ConvertUtil.convertPositionToStr(position1);
        String toStr2 = ConvertUtil.convertPositionToStr(position2);

        //then
        assertEquals(toStr1, "---");
        assertEquals(toStr2, "----");

    }

}
