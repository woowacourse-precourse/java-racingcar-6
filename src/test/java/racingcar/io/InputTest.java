package racingcar.io;


import org.junit.jupiter.api.*;
import racingcar.model.Cars;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @AfterEach
    void clearSystemIn() {
        Input.consoleClose();
    }

    @Test
    @DisplayName("Cars 객체가 잘 생성되는지 확인하는 테스트")
    void testReadCars() {
        Input input = new Input();
        String userInput = "A,B,C";
        setSystemInput(userInput);
        Cars cars = input.readCars();
        List<String> names = cars.getName();
        List<Integer> scores = cars.getScore();
        assertEquals(3, names.size());
        assertEquals(3, scores.size());
        assertThat(names).contains("A", "C");
        assertThat(names).containsExactly("A", "B", "C");
        assertEquals(Arrays.asList(0, 0, 0), scores);
    }

    @Test
    @DisplayName("입력한 자연수가 Integer타입으로 변환이 잘 되는지 테스트")
    void testReadRounds() {
        Input input = new Input();
        String userInput = "5";
        setSystemInput(userInput);
        Integer rounds = input.readRounds();
        assertEquals(Integer.parseInt(userInput), rounds);
    }

    private void setSystemInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}