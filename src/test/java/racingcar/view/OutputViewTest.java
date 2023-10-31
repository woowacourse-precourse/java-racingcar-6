package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Vehicle;

class OutputViewTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void 테스트_함수_실행_전_실행() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void 테스트_함수_실행_후_실행() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("실행결과 문구 출력 테스트")
    void outputExecuteResult() {
        OutputView.outputExecuteResult();
        String outputMessage = outputStream.toString().trim();
        assertEquals(OutputMessages.EXECUTE_RESULT.getMessage().trim(), outputMessage);
    }

    @Test
    @DisplayName("자동차 이동거리 출력 테스트")
    void outputDistanceResult() {
        List<Vehicle> carList = List.of(new Car("jang", 0), new Car("pobi", 1));
        carList.get(0).advance();
        carList.get(0).advance();
        carList.get(1).advance();

        OutputView.outputDistanceResult(carList);
        String outputMessage = outputStream.toString().replace("\n", "");
        outputMessage = outputMessage.replace("jang : --", "");
        outputMessage = outputMessage.replace("pobi : -", "");
        assertEquals(0, outputMessage.length());
    }
}