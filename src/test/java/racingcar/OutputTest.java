package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
    @Test //4번 기능 테스트
    void printGuideCarName() {
        Output.printGuideCarName();
        String expectedOutput = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test //5번 기능 테스트
    void printGuideTryCount() {
        Output.printGuideTryCount();
        String expectedOutput = "시도할 회수는 몇회인가요?";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test //6번 기능 테스트
    void printResult() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        cars.get(0).setPosition(1L);
        cars.get(1).setPosition(2L);
        cars.get(2).setPosition(3L);

        Output.printResult(cars);
        String expectedOutput = "pobi : -\ncrong : --\nhonux : ---";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim().replaceAll("\r\n", "\n"));
    }

    @Test //7번 기능 테스트
    void printWinner() {
        List<Car> winnerCars = List.of(new Car("pobi"), new Car("honux"));

        Output.printWinner(winnerCars);
        String expectedOutput = "최종 우승자 : pobi, honux";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}