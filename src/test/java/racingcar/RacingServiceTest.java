package racingcar;

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

class RacingServiceTest {

    private static RacingService racingService;
    private ByteArrayOutputStream outputStream;

    @BeforeAll()
    static void RacingController_객체_생성() {
        racingService = new RacingService();
    }

    @BeforeEach()
    void 출력_캡처_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test()
    void 자동차_이름_입력_예외처리후_파싱_예외발생() {
        String testCarsName = "carcar";
        assertThrows(IllegalArgumentException.class, () -> {
            racingService.carInputExceptionAndParsing(testCarsName);
        });
    }

    @Test()
    void 자동차_이름_입력_예외처리후_파싱_정상() {
        String testCarsName = "car,cars";
        List<Car> testResult = racingService.carInputExceptionAndParsing(testCarsName);
        assertThat(testResult).extracting(Car::getName).
                containsExactly("car","cars");
    }

    @Test()
    void 시도횟수_입력_예외처리후_파싱_예외발생() {
        String testTryCount = "notInteger";
        assertThrows(IllegalArgumentException.class, () -> {
            racingService.tryCountExceptionAndParsing(testTryCount);
        });
    }

    @Test()
    void 시도횟수_입력_예외처리후_파싱_정상() {
        String testTryCount = "24";
        int testResult = racingService.tryCountExceptionAndParsing(testTryCount);
        assertThat(testResult).isEqualTo(24);
    }

    @Test
    void 경주_실행결과_계산후_출력_자동차_하나() {
        List<Car> testCar = new ArrayList<>(List.of(new Car("one", new StringBuilder("---"), 3)));
        racingService.playRacing(testCar);
        String output = outputStream.toString();
        assertThat(output).contains("one : ---");
    }

    @Test
    void 경주_실행결과_계산후_출력_자동차_두대() {
        List<Car> testCar = new ArrayList<>(
                List.of(new Car("one", new StringBuilder("---"), 3),new Car("two", new StringBuilder("--"), 2)));
        racingService.playRacing(testCar);
        String output = outputStream.toString();
        assertThat(output).contains("one : ---", "two : --");
    }

}