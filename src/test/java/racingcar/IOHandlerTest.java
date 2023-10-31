package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class IOHandlerTest {

    IOHandler ioHandler = new IOHandler();

    @Test
    void 우승자_한_명_출력하기() {
        // 콘솔 출력 값을 확인하기 위한 설정
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> winners = List.of("winner");
        ioHandler.printWinners(winners);

        assertThat(outputStream.toString()).contains("최종 우승 : winner");

        // 표준 출력을 처음 상태로 되돌리기
        System.setOut(System.out);
    }

    @Test
    void 우승자_두_명_출력하기() {
        // 콘솔 출력 값을 확인하기 위한 설정
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> winners = List.of("winner1", "winner2");
        ioHandler.printWinners(winners);

        assertThat(outputStream.toString()).contains("최종 우승 : winner1, winner2");

        // 표준 출력을 처음 상태로 되돌리기
        System.setOut(System.out);
    }

    @Test
    void 전진_시도_결과_출력하기() {
        // 콘솔 출력 값을 확인하기 위한 설정
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Car> cars = List.of(new Car("car1", 1), new Car("car2", 2), new Car("car3", 3));
        ioHandler.printAttemptResult(cars);

        assertThat(outputStream.toString()).contains("""
                car1 : -
                car2 : --
                car3 : ---
                """);

        // 표준 출력을 처음 상태로 되돌리기
        System.setOut(System.out);
    }
}