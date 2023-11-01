package racingcar;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarMethodTest {

    @Test
    void isCarnameTooLong_메서드에_길이제한을_초과한_입력이_있을_시_true를_반환(){

        List<String> inputList = List.of("pobi", "woni", "javajigi");
        int inputMaxLength = 5;

        var result = Application.isCarnameTooLong(inputList, inputMaxLength);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void determineGoOrStop_메서드에_4_이상의_값이_입력될_경우_key값의_value를_1만큼_증가(){

        Map<String, Integer> carMap = new HashMap<>();
        String testCar = "testCar";
        carMap.put(testCar, 1);

        Application.determineGoOrStop(carMap, testCar, 5);
        var result = carMap.get(testCar);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void determineGoOrStop_메서드에_3_이하의_값이_입력될_경우_key값의_value를_유지(){

        Map<String, Integer> carMap = new HashMap<>();
        String testCar = "testCar";
        carMap.put(testCar, 1);

        Application.determineGoOrStop(carMap, testCar, 2);
        var result = carMap.get(testCar);

        assertThat(result).isEqualTo(1);
    }

}
