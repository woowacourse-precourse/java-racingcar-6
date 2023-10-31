package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveNumInputTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    @DisplayName ("자동차 이동횟수 입력 정상동작 테스트")
    void canGetMoveNameGeneralTest(String testInput) throws NoSuchFieldException, IllegalAccessException {
        MoveNum moveNum = new MoveNum(testInput);
        Field field = moveNum.getClass().getDeclaredField("num");

        field.setAccessible(true);
        assertThat(Integer.parseInt(testInput)).isEqualTo((int)field.get(moveNum));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (입력이 없을때)")
    void canHandleEmptyInputMoveNumExceptionTest(String testInput) {
    assertThatThrownBy(() -> new MoveNum(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 시도할 회수에 값이 들어오지 않았습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "English", "-500", "50섞어서", "5a1"})
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (0 또는 양수가 아닌 값이 들어온 경우)")
    void canHandleNotInputMoveNumExceptionTest(String testInput) {
        assertThatThrownBy(() -> new MoveNum(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 시도할 회수에 0 또는 양수가 아닌 값이 포함되었습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483649", "10001"})
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (이동횟수가 너무 많은 경우)")
    void canHandleOverLengthMoveNumExceptionTest(String testInput) {
        final int MAX_MOVE_NUM = 10000;

        assertThatThrownBy(() -> new MoveNum(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 시도할 회수가 너무 많습니다 최대회수 " + MAX_MOVE_NUM);
    }

    @Test
    @DisplayName("자동차 이동횟수 입력 안내 메시지 출력 확인")
    void canPrintMoveNumInputInformationTest() throws Exception{
        String lineSeparator = System.lineSeparator();
        InputStream input = new ByteArrayInputStream("10".getBytes());

        System.setIn(input);
        RacingSetting racingSetting = new RacingSetting();
        racingSetting.getMoveNum();
        assertThat(output.toString())
                .isEqualTo("시도할 회수는 몇회인가요?" + lineSeparator);
    }
}
