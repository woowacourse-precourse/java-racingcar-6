package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDataCheckTest {
    @Test
    void 자동차_이름이_6자_이상이면_예외_발생(){
        LinkedHashMap<String, Integer> CarData = new LinkedHashMap<>();
        CarData.put("abcdef", 0);

        CarDataCheck carDataCheck = new CarDataCheck();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carDataCheck.checkCarNameIsValid(CarData);
        });
    }

    @Test
    void 이동거리와_시도한_회수가_동일한지_확인(){
        int tryNumber = 5;

        LinkedHashMap<String, Integer> carData = new LinkedHashMap<>();
        carData.put("pobi", 4);
        carData.put("woni", 5);
        carData.put("jun", 2);

        CarDataCheck carDataCheck = new CarDataCheck();

        assertThat(carDataCheck.checkFinishedTime(carData, tryNumber)).isTrue();
    }
}
