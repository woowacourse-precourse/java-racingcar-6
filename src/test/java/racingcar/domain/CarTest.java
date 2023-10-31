package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;
    private InputStream standardIn; // inputCarName을 standardIn으로 변경

    @BeforeEach
    void setUp() {
        car = new Car();
        standardIn = System.in;
    }

    @AfterEach
    public void cleanUp() {
        System.setIn(standardIn); // restoreStreams을 cleanUp으로 변경
    }
    @Test
    @DisplayName("입력된 자동차 이름을 정상적으로 반환")
    void successGetNames() {
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = car.getNames();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("입력된 자동차 이름을 쉼표(,)를 기준으로 구분하지 못하기")
    void failGetNames() {
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> expected = List.of("pobi,woni,jun");
        List<String> result = car.getNames();

        assertNotEquals(expected, result);
    }

    @Test
    @DisplayName("입력된 자동차 이름에 빈값 존재")
    void testGetNamesWithEmptyInput() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> car.getNames());
    }

    @Test
    @DisplayName("입력된 자동차 이름에 빈값 존재")
    void testGetNamesWithEmptyInputContainingEmptyValues() {
        String input = "pobi,,woni\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> car.getNames());
    }

    @Test
    @DisplayName("입력된 자동차 이름의 마지막에 빈값 존재")
    void testGetNamesWithInvalidInput() {
        String input = "pobi,woni,jun,\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> car.getNames());
    }

    @Test
    @DisplayName("입력된 자동차 이름에 중복 값 존재")
    void testGetNamesWithDuplicateInput() {
        String input = "pobi,woni,jun,pobi\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> car.getNames());
    }

    @Test
    @DisplayName("입력된 자동차 이름에 5자 초과된 값 존재")
    void testGetNamesWithLongInput() {
        String input = "pobi,woni,jun,longname\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> car.getNames());
    }
}