package racingcar.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Entity.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsolePrintTest {
    private static ConsolePrint consolePrint;
    private ByteArrayOutputStream outputStream;

    @BeforeAll()
    static void ConsolePrint_객체_생성() {
        consolePrint = new ConsolePrint();
    }

    @BeforeEach()
    void 출력_캡처_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 레이싱_결과_출력_0번_이동() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder(), 0));
        testCars.add(new Car("two", new StringBuilder(), 0));

        consolePrint.racingTryResult(testCars);
        String output = outputStream.toString();
        assertThat(output).contains("one : ", "two : ");
    }

    @Test
    void 레이싱_결과_출력_2번_3번_0번_이동() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder("--"), 2));
        testCars.add(new Car("two", new StringBuilder("---"), 3));
        testCars.add(new Car("three", new StringBuilder(), 0));

        consolePrint.racingTryResult(testCars);
        String output = outputStream.toString();
        assertThat(output).contains("one : --", "two : ---", "three : ");
    }

    @Test
    void 우승자_출력_1명() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder("--"), 2));

        consolePrint.finalWinner(testCars);
        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : one");
    }

    @Test
    void 우승자_출력_3명() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("one", new StringBuilder("--"), 2));
        testCars.add(new Car("two", new StringBuilder("--"), 2));
        testCars.add(new Car("three", new StringBuilder("--"), 2));

        consolePrint.finalWinner(testCars);
        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : one, two, three");
    }

}
