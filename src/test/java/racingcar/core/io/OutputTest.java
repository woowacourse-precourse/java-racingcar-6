package racingcar.core.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    private Output output;

    @BeforeEach
    void before() {
        output = new Output();
    }
    @Test
    @DisplayName("결과 출력 테스트")
    void 결과_출력_테스트() throws Exception {
        //given
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));

        for (Car car : cars) {
            car.tryMove();
        }

        //when
        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();;
        System.setOut(new PrintStream(systemOutContent));

        output.printResult(cars);
        //then
        String expected1 = "실행 결과";
        String expected2 = "car1";
        String expected3 = "car2";
        assertThat(systemOutContent.toString()).contains(expected1);
        assertThat(systemOutContent.toString()).contains(expected2);
        assertThat(systemOutContent.toString()).contains(expected3);
    }
    @Test
    @DisplayName("싱글 우승 결과 출력 테스트")
    void 싱글_우승_결과_출력_테스트() throws Exception {
        //given
        List<String> winner = List.of("car1");
        //when
        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();;
        System.setOut(new PrintStream(systemOutContent));

        output.printWinner(winner);
        //then
        String expected1 = "최종 우승자";
        String expected2 = "car1";
        assertThat(systemOutContent.toString()).contains(expected1);
        assertThat(systemOutContent.toString()).contains(expected2);
    }
    @Test
    @DisplayName("멀티 우승 결과 출력 테스트")
    void 멀티_우승_결과_출력_테스트() throws Exception {
        //given
        List<String> winner = List.of("car1","car2");
        //when
        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();;
        System.setOut(new PrintStream(systemOutContent));

        output.printWinner(winner);
        //then
        String expected1 = "최종 우승자";
        String expected2 = "car1";
        String expected3 = "car2";
        assertThat(systemOutContent.toString()).contains(expected1);
        assertThat(systemOutContent.toString()).contains(expected2);
        assertThat(systemOutContent.toString()).contains(expected3);
    }
}