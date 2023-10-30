package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.*;

public class MyMethodTest {

    @Test
    void validateInput_입력받은_차들의_자릿수가_5초과면_예외_발생() {
        // input
        String carNamesInput = "jia,  uis, vh1uh3";
        String[] inputs = carNamesInput.split(",");

        assertThatThrownBy(() -> validateInput(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("CarName can not exceed over 5 character");
    }

    @Test
    void validateNumber_입력받은_횟수가_숫자가_아니면_예외_발생() {
        // input
        String number = "dw";

        assertThatThrownBy(() -> validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This should be only number");
    }


    @Test
    void carListToMap_메서드_사용시_리스트를_맵으로_초기화() {
        List<String> cars = new ArrayList<>();
        cars.add("pony");
        cars.add("benz");
        cars.add("genesis");

        Map<String, Integer> map = carListToMap(cars);

        for (String car : map.keySet()) {
            assertThat(map.get(car)).isZero();
        }
    }

    @Test
    void printWinResult_메서드_사용시_map의_수만큼_출력한다() {
        Map<String, Integer> carsWithWins = new HashMap<>();

        carsWithWins.put("pony", 3);
        carsWithWins.put("benz", 2);
        carsWithWins.put("genesis", 5);

        printWinResult(carsWithWins);

    }

}


