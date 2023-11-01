package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveNumInputTest {
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
    @ValueSource(strings = {"1", "10", "100"})
    @DisplayName ("자동차 이동횟수 입력 정상동작 테스트")
    void canGetMoveNameGeneralTest(String testInput) throws NoSuchFieldException, IllegalAccessException {
        MoveNum moveNum = new MoveNum(testInput);
        Field field = moveNum.getClass().getDeclaredField("value");

        field.setAccessible(true);
        assertThat(Integer.parseInt(testInput)).isEqualTo((int)field.get(moveNum));
    }

    @Test
    @DisplayName ("자동차 이동횟수보다 적은값인지 확인하는 기능 테스트")
    void canMoveNumIsInRangeTest() throws NoSuchFieldException, IllegalAccessException {
        MoveNum moveNum = new MoveNum("10");

        assertThat(true).isEqualTo(moveNum.isInRange(9));
        assertThat(false).isEqualTo(moveNum.isInRange(10));
        assertThat(false).isEqualTo(moveNum.isInRange(50));
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

    @Test
    @DisplayName ("자동차 이동횟수 입력 예외동작 테스트 (0만있거나 0 또는 양수가 아닌 값이 들어온 경우)")
    void canHandleNotInputMoveNumExceptionTest() {
        assertThatThrownBy(() -> new MoveNum("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error : 최소 1이상의 값을 입력해주세요");
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
        OutputPrinter.printMoveNumInputRequestMessage();
        assertThat(output.toString())
                .isEqualTo("시도할 회수는 몇회인가요?" + System.lineSeparator());
    }
}
