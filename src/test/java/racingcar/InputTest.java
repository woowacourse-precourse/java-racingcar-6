package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test //1번 기능 테스트
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

    @Test //2번 기능 테스트
    void getTryCount() {
        // 정상 입력
        assertDoesNotThrow(() -> Input.getTryCount("123"));

        // null 입력
        assertThrows(IllegalArgumentException.class, () -> Input.getTryCount(null));

        // input이 자연수가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> Input.getTryCount("ㅁㄴㅇㄹ"));

        String input = "123"; // 유효한 입력 예시
        Long tryCount = Input.getTryCount(input);
        Long expectedTryCount = 123L;
        assertEquals(expectedTryCount, tryCount);
    }
}