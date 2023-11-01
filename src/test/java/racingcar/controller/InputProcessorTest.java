package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputProcessorTest {
    @Test
    void userCarInputProcessorTest() {
        ArrayList<String> expectedUserCar = new ArrayList<>();
        expectedUserCar.add("안녕");

        List<String> userCar = InputProcessor.userCarInputProcessor("안녕");

        assertThat(expectedUserCar).isEqualTo(userCar);
    }

    @Test
    void userCarsInputProcessorTest() {
        ArrayList<String> expectedUserCars = new ArrayList<>();
        expectedUserCars.add("1234");
        expectedUserCars.add("안녕");

        List<String> userCars = InputProcessor.userCarInputProcessor("1234, 안녕");

        assertThat(expectedUserCars).isEqualTo(userCars);
    }

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

    @Test
    void totalRoundInputProcessorTest() {
        assertThat(1).isEqualTo(InputProcessor.totalRoundInputProcessor("1"));
    }

    @Test
    void totalRoundInputProcessorErrorTest() {
        assertThrows(IllegalArgumentException.class,
            () -> InputProcessor.totalRoundInputProcessor("안"));
    }
}