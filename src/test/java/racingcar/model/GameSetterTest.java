package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSetterTest {

    @BeforeEach
    void setUp() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // 입력 문자열을 바이트 배열로 변환한 후 ByteArrayInputStream으로 전달
        String inputString = "Car1, Car2, Car3";
        byte[] inputBytes = inputString.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        System.setIn(inputStream);
    }

    @DisplayName("[GameSetter] inputCarName 테스트")
    @Test
    void inputCarNameTest() {
        // Given
        GameSetter gameSetter = new GameSetter();
        // When
        List<Car> carList = gameSetter.inputCarName();
        // Then
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("Car1");
        assertThat(carList.get(1).getName()).isEqualTo("Car2");
        assertThat(carList.get(2).getName()).isEqualTo("Car3");
    }

    @AfterEach
    void tearDown() {
        // 원래의 System.in 및 System.out으로 복원
        System.setOut(System.out);
        System.setIn(System.in);
    }

}