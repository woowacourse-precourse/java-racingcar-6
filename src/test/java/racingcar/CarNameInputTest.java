package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameInputTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
        Console.close();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @ParameterizedTest
    @ValueSource(strings = {"부릉이,따릉이,딸랑이", "부릉이,따릉이", "부릉이"})
    @DisplayName ("경주할 자동차 이름입력 정상동작 테스트")
    void canGetCarNameGeneralTest(String testInput) {
        String[] answer = testInput.split(",");

        RacingCars racingCars = new RacingCars(testInput);
        assertArrayEquals(answer, racingCars.getCarName());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (입력이 없을때)")
    void canHandleEmptyInputCarNameExceptionTest(String testInput) {
        assertThatThrownBy(() -> new RacingCars(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 개수가 너무 적습니다 최소 하나라도 입력해 주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"부릉이,,", "부릉이,", "부릉이,,따릉이", ",부릉이"})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (쉼표가 나오고 자동차 이름이 나오지않은경우)")
    void canHandleNotInputCarNameExceptionTest(String testInput) {
        assertThatThrownBy(() -> new RacingCars(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  "})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (이름에 공백만 들어온 경우)")
    void canHandleOnlyWhiteSpaceCarNameExceptionTest(String testInput) {
        assertThatThrownBy(() -> new Car(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
    }

    @Test
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (이름이 너무 긴 경우)")
    void canHandleOverLengthCarNameExceptionTest() {
        final int MAX_CAR_NAME = 5;

        assertThatThrownBy(() -> new Car("부릉부릉부릉"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 너무 깁니다 이름 최대 길이 " + MAX_CAR_NAME);
    }

    @Test
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (중복된 이름이 들어온 경우)")
    void canHandleDuplicateCarNameExceptionTest() {
        assertThatThrownBy(() -> new RacingCars("부릉이,부릉이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 중복된 자동차 이름이 있습니다 중복되지않게 입력해 주세요");
    }

    @Test
    @DisplayName("자동차 이름 입력 안내 메시지 출력 확인")
    void canPrintCarNameInputInformationTest() throws Exception{
        OutputPrinter.printRacingCarsInputRequestMessage();
        assertThat(output.toString())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator());
    }
}
