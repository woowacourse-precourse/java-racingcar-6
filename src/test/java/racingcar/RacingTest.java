package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    public void testInsertCarName() {
        // 시뮬레이트할 입력
        String input = "car1,car2,car3";

        // 메서드 호출
        List<Car> cars = Application.insertCarName(input);

        // 결과 검증
        assertEquals(3, cars.size());
    }

    @Test
    public void testInsertCarName_InvalidInput() {
        // 시뮬레이트할 입력
        String input = "car1,car2,car3456";
        // Console.readLine()을 모의(Mock)화하고 입력값 설정

        // 메서드 호출 및 예외 검증
        assertThrows(IllegalArgumentException.class, () -> {
            Application.insertCarName(input);
        });
    }
}
