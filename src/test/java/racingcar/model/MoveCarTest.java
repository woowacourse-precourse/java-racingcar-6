package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MoveCarTest {

    @Test
    void 자동차_레이싱_정상작동_확인() {
        String testString = "a,b,c";
        List<String> splitTestString = Arrays.stream(testString.split(",")).toList();
        String tryNumber = "10";

        MoveCar moveCar = new MoveCar(splitTestString, tryNumber);
        moveCar.moveCarTryNumber();
        Map<String, Integer> carMap = moveCar.getCarPositionMap();
        System.out.println(carMap);
    }
}
