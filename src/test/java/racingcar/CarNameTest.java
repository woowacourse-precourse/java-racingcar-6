package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameTest {


    @Test
    void 리스트_나누기() {

        //given
        List<String> splitCarList = new ArrayList<>();
        String inputCar = "pobi,jun,jason";

        //when
        String[] splitCars = inputCar.split(",");
        for (String car : splitCars) {
            splitCarList.add(car);
        }

        //then
        assertThat(splitCarList.size()).isEqualTo(3);

    }

    @Test
    void 글자수_제한_5() {

        //given
        List<String> splitCarList = Arrays.asList("pobi", "Alexes", "jason");

        //when, then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    if (splitCarList.get(1).length() > 5) {
                        throw new IllegalArgumentException("테스트 에러");
                    }
                });
    }




}
