package domain.gameInfoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.gameInfo.InputCars;

public class InputCarsTest {

    @Test
    @DisplayName("자동차가 순차적으로 저장이 되는지 검증")
    public void 자동차_입력_테스트() throws Exception {
        //given
        InputCars inputCars = new InputCars("pobi,woni,jun");
        //when
        List<Car> parsedCarList = inputCars.getParsedCarList();
        //then

        assertEquals("pobi", parsedCarList.get(0).getName());
        assertEquals("woni", parsedCarList.get(1).getName());
        assertEquals("jun", parsedCarList.get(2).getName());
    }

    @Test
    @DisplayName("자동차 리스트에 공백이 존재하면 안 된다.")
    public void 자동차_파싱_테스트() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new InputCars("pobi, ,jun"));
    }

    @Test
    @DisplayName("자동차 리스트에 5글자를 넘어가는 자동차가 존재하면 안 된다.")
    public void 자동차_공백_테스트() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new InputCars("pobi,seokhwan,jun"));
    }

    @Test
    @DisplayName("자동차 리스트에 중복이 존재하면 안 된다.")
    public void 자동차_중복_테스트() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new InputCars("pobi,pobi,seokhwan"));
    }
}
