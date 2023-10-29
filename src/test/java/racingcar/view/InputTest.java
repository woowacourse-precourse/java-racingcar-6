package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputTest {
    private InputStream originalSystemIn;

    @AfterEach
    void cleanup() {
        Console.close();
    }

    @Test
    void getCarNames_확인() {
        // Given: 사용자가 입력한 자동차 이름
        setMockInput("car1, car2, car3");

        // When: getCarNames 메서드 호출
        List<String> carNames = Input.getCarNames();

        // Then: 자동차 이름이 올바르게 파싱되었는지 확인
        assertEquals(3, carNames.size());
        assertTrue(carNames.contains("car1"));
        assertTrue(carNames.contains("car2"));
        assertTrue(carNames.contains("car3"));
    }

    @Test
    void getTotalRace_확인() {
        // Given: 사용자가 입력한 시도할 회수
        setMockInput("5");

        // When: getTotalRace 메서드 호출
        int totalRace = Input.getTotalRace();

        // Then: 시도할 회수가 올바르게 파싱되었는지 확인
        assertEquals(5, totalRace);
    }

    @Test
    void getTotalRace_예외_처리() {
        // Given: 사용자가 잘못된 형식의 시도할 회수 입력
        setMockInput("invalid_input");

        // When: getTotalRace 메서드 호출
        assertThrows(IllegalArgumentException.class, Input::getTotalRace);
    }

    private void setMockInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}