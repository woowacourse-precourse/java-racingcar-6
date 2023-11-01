package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void getCarNames() {
        // 정상 입력
        assertDoesNotThrow(() -> Input.getCarNames("Car1,Car2,Car3"));

        // null 입력
        assertThrows(IllegalArgumentException.class, () -> Input.getCarNames(null));

        // 이름 길이가 5자 이상
        assertThrows(IllegalArgumentException.class, () -> Input.getCarNames("Car1,Car22,Car333"));

        // 빈 이름 포함
        assertThrows(IllegalArgumentException.class, () -> Input.getCarNames("Car1,,Car3"));


        String input = "Car1,Car2,Car3"; // 유효한 입력 예시
        List<String> carNames = Input.getCarNames(input);
        // 예상되는 자동차 이름 목록과 반환된 자동차 이름 목록을 비교
        List<String> expectedCarNames = List.of("Car1", "Car2", "Car3");
        assertEquals(expectedCarNames, carNames);
    }

}