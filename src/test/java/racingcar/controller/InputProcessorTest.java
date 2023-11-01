package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests class InputProcessor method function correctly
 */
class InputProcessorTest {

    /**
     * Tests method userCarInputProcessor if it processes car name correctly
     */
    @Test
    void userCarInputProcessorTest() {
        // given
        ArrayList<String> expectedUserCar = new ArrayList<>();
        expectedUserCar.add("안녕");

        // when
        List<String> actualUserCar = InputProcessor.userCarInputProcessor("안녕");

        // then
        assertThat(actualUserCar).isEqualTo(expectedUserCar);
    }

    /**
     * Tests method userCarInputProcessor if it processes multiple car names correctly
     */
    @Test
    void userCarsInputProcessorTest() {
        // given
        ArrayList<String> expectedUserCars = new ArrayList<>();
        expectedUserCars.add("1234");
        expectedUserCars.add("안녕");

        // when
        List<String> actualUserCars = InputProcessor.userCarInputProcessor("1234, 안녕");

        // then
        assertThat(actualUserCars).isEqualTo(expectedUserCars);
    }

    /**
     * Tests method userCarInputProcessor if it handles invalid inputs correctly
     */
    @Test
    void userCarInputProcessorErrorTest() {

        // List 공백 검사
        assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.userCarInputProcessor(""));

        // List 공백 검사
        assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.userCarInputProcessor(","));

        // 공백 원소 검사
        assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.userCarInputProcessor(", 가나"));

        // 5자 초과 검사
        assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.userCarInputProcessor("가나라마바사, 가나"));

        // 중복 검사
        assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.userCarInputProcessor("가나, 가나"));

    }

    /**
     * Tests method totalRoundInputProcessor if it processes totalRound correctly
     */
    @Test
    void totalRoundInputProcessorTest() {
        // then
        assertThat(InputProcessor.totalRoundInputProcessor("1")).isEqualTo(1);
    }

    /**
     * Tests method totalRoundInputProcessor if it handles invalid inputs correctly
     */
    @Test
    void totalRoundInputProcessorErrorTest() {
        // then
        assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.totalRoundInputProcessor("안"));
    }
}