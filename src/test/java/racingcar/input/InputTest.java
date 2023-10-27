package racingcar.input;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.cars.Car;
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

        String carName = cars.getCarNames().get(0).toString();
        int moveRecord = 5;

        cars.printMoveRecord(carName, moveRecord);
        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("tiger : -----");
    }

    @Test
    @DisplayName("최종 결과 가장 많이 이동한 단독 우승자 출력")
    public void testPrintSoloWinner() {
        Cars cars = new Cars("lamb");

        cars.addCar("tiger", 3);
        cars.addCar("bear", 5);
        cars.addCar("eagle", 4);

        cars.printWinner();
        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("최종 우승자 : bear");
    }

    @Test
    @DisplayName("최종 결과 가장 많이 이동한 공동 우승자 쉼표(,)로 구분하여 출력")
    public void testPrintCoWinner() {
        Cars cars = new Cars("lamb");

        cars.addCar("tiger", 3);
        cars.addCar("bear", 5);
        cars.addCar("eagle", 5);

        cars.printWinner();
        String output = byteArrayOutputStream.toString();
        Assertions.assertThat(output.trim()).isEqualTo("최종 우승자 : bear, eagle");
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
