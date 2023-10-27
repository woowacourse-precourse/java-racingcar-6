package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void inputCarNames() {
        // Arrange
        Race race = new Race();

        // Act
        // 여기서는 입력을 시뮬레이트하기 어려우므로 직접 값을 넣어준다.
        String inputList = "Car1,Car2,Car3";
        System.setIn(new ByteArrayInputStream(inputList.getBytes()));

        Input.inputCarNames(race);

        // Assert
        // 예상된 결과와 실제 결과를 비교
        ArrayList<String> carNames = race.getCarNames();
        assertEquals(3, carNames.size());
        assertTrue(carNames.contains("Car1"));
        assertTrue(carNames.contains("Car2"));
        assertTrue(carNames.contains("Car3"));
    }

    @Test
    void inputTryNumber() {
        // Arrange
        // 시뮬레이션을 위해 System.in을 변경한다.
        String inputNumber = "5";
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));

        // Act
        int tryNumber = Input.inputTryNumber();

        // Assert
        // 예상된 결과와 실제 결과를 비교한다.
        assertEquals(5, tryNumber);
    }

    @Test
    public void testInputTryNumberInvalid() {
        // Arrange
        // 시뮬레이션을 위해 System.in을 변경한다.
        String inputNumber = "-1"; // 유효하지 않은 값
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));

        // Act & Assert
        // IllegalArgumentException이 발생해야 한다.
        assertThrows(IllegalArgumentException.class, () -> {
            Input.inputTryNumber();
        });
    }
}