package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;
    private InputStream inputCarNames;

    @BeforeEach
    void setUp() {
        car = new Car();
        inputCarNames = System.in;
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
    @DisplayName("입력된 자동차 이름을 쉼표(,)를 기준으로 구분")
    void testSuccessSplitInputNames() {
        String input = "pobi,woni,jun";

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = car.splitInputNames(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("입력된 자동차 이름을 쉼표(,)를 기준으로 구분")
    void testFailSplitInputNames() {
        String input = "pobi,woni,jun";

        List<String> expected = List.of("pobi,woni,jun");
        List<String> result = car.splitInputNames(input);

        assertNotEquals(expected, result);
    }

    @Test
    @DisplayName("입력된 자동차 이름에 빈값 존재")
    void testGetNamesWithEmptyInput() {
        List<String> carNames = Arrays.asList("");

        assertThatThrownBy(() -> car.checkEmpty(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 자동차 이름에 빈값 존재")
    void testGetNamesWithEmptyInputContainingEmptyValues() {
        List<String> carNames = Arrays.asList("pobi", "", "jun");

        assertThatThrownBy(() -> car.checkEmpty(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 자동차 이름의 마지막에 빈값 존재")
    void testGetNamesWithInvalidInput() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun", "");

        assertThatThrownBy(() -> car.checkEmpty(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 자동차 이름에 중복 값 존재")
    void testGetNamesWithDuplicateInput() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun", "pobi");

        assertThatThrownBy(() -> car.checkDuplicate(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 자동차 이름에 5자 초과된 값 존재")
    void testGetNamesWithLongInput() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun", "longname");

        assertThatThrownBy(() -> car.checkLength(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}