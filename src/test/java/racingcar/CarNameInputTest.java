package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import camp.nextstep.edu.missionutils.Console;
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
    @ValueSource(strings = {"부릉이,따릉이,딸랑이"})
    @DisplayName ("경주할 자동차 이름입력 정상동작 테스트")
    void canGetCarNameGeneralTest(String testInput) {
        String[] answer = {"부릉이", "따릉이", "딸랑이"};
        RacingSetting racingSetting = new RacingSetting();
        InputStream input = new ByteArrayInputStream(testInput.getBytes());

        System.setIn(input);
        assertArrayEquals(answer, racingSetting.getName());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (입력이 없을때)")
    void canHandleEmptyInputCarNameExceptionTest(String testInput) {
        RacingSetting racingSetting = new RacingSetting();
        InputStream input = new ByteArrayInputStream(testInput.getBytes());

        System.setIn(input);
        assertThatThrownBy(racingSetting::getName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"부릉이,,", "부릉이,", "부릉이,,따릉이", ",부릉이"})
    @DisplayName ("경주할 자동차 이름입력 예외동작 테스트 (쉼표가 나오고 자동차 이름이 나오지않은경우)")
    void canHandleNotInputCarNameExceptionTest(String testInput) {
        RacingSetting racingSetting = new RacingSetting();
        InputStream input = new ByteArrayInputStream(testInput.getBytes());

        System.setIn(input);
        assertThatThrownBy(racingSetting::getName)
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
        RacingSetting racingSetting = new RacingSetting();
        InputStream input = new ByteArrayInputStream("부릉이,부릉이".getBytes());

        System.setIn(input);
        assertThatThrownBy(() -> racingSetting.getName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 자동차 이름이 중복되었습니다 중복되지않게 적어주세요");
    }

    @Test
    @DisplayName("자동차 이름 입력 안내 메시지 출력 확인")
    void canPrintCarNameInputInformationTest() throws Exception{
        RacingSetting racingSetting = new RacingSetting();
        String lineSeparator = System.lineSeparator();
        InputStream input = new ByteArrayInputStream("부릉이".getBytes());

        System.setIn(input);
        racingSetting.getName();
        assertThat(output.toString())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + lineSeparator);
    }
}
