package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.console.RacingCarConsole;

public class RacingCarOutputConsoleTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    void 최종_우승자_출력_1대_정상처리() {
        List<Car> carList = List.of(
                new Car("bae")
        );
        CarRacingResult carRacingResult = new CarRacingResult(carList);

        RacingCarConsole.printCarRacingResult(carRacingResult);
        String result = outputMessage.toString();

        assertThat(result).isEqualTo("\n최종 우승자 : bae\r\n");
    }

    @Test
    void 최종_우승자_출력_2대_정상처리() {
        List<Car> carList = List.of(
                new Car("bae"),
                new Car("sue")
        );
        CarRacingResult carRacingResult = new CarRacingResult(carList);

        RacingCarConsole.printCarRacingResult(carRacingResult);
        String result = outputMessage.toString();

        assertThat(result).isEqualTo("\n최종 우승자 : bae, sue\r\n");
    }

    @Test
    void 최종_우승자_출력_20대_영어_랜덤이름_정상처리() {
        Random random = new Random();
        List<String> nameList = IntStream.range(1, 20)
                .mapToObj(number ->
                        random.ints(97, 123)
                                .limit(5)
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString()
                ).toList();

        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append(nameList.get(0));
        for (int i = 1; i < nameList.size(); i++) {
            expectedStringBuilder.append(", ");
            expectedStringBuilder.append(nameList.get(i));
        }
        String expectedString = "\n최종 우승자 : " + expectedStringBuilder + "\r\n";

        List<Car> carList = nameList.stream().map(Car::new)
                .toList();

        CarRacingResult carRacingResult = new CarRacingResult(carList);

        RacingCarConsole.printCarRacingResult(carRacingResult);
        String resultString = outputMessage.toString();

        assertThat(resultString).isEqualTo(expectedString);
    }
}
