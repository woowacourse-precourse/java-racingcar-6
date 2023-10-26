package racingcar.input;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("자동차 입력 문구 출력 테스트")
    public void testInputCarsMessage() {
        Input input = new Input();

        input.printInputCarsMessage();
        String output = byteArrayOutputStream.toString();

        Assertions.assertThat(output.trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)로 구분하여 리스트에 저장하는지 테스트")
    public void testCarNamesAreParsedAndStore() {
        Input input = new Input();

        List<String> cars = Arrays.asList("tiger", "eagle", "bear");
        String carNames = "tiger,eagle,bear";

        Assertions.assertThat(input.parsedCarsName(carNames)).isEqualTo(cars);
    }

    @Test
    @DisplayName("입력값에 최대 길이(5)를 초과하는 자동차 이름이 포함되어 있을 때 에러가 발생 테스트 ")
    public void testInputCarNameExceedsMaxLength() {
        Input input = new Input();

        String carNames = "lion,leopard,cow";
        List<String> cars = input.parsedCarsName(carNames);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> input.isValidCarNameLength(cars));
    }
}
