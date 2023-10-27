package racingcar.input;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.cars.Cars;

public class InputTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final Input input = new Input();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("자동차 입력 문구 출력 테스트")
    public void testInputCarsMessage() {
        input.printInputCarsMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도 횟수 입력 문구 출력 테스트")
    public void testInputAttemptCountMessage() {
        input.printInputAttemptCountMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("각 횟수별 전진 결과 출력 테스트")
    public void testMoveResult() {
        Cars cars = new Cars("tiger,eagle,bear");

        String carName = cars.getCars().get(0).toString();
        int moveRecord = 5;

        cars.printMoveRecord(carName, moveRecord);
        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output).isEqualTo("tiger : -----");
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
