package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Input;
import racingcar.domain.InputGenerator;
import racingcar.domain.Player;
import racingcar.domain.Validate;

public class InputTest {
    @Test
    public void Player_이름이_5글자가_넘는_경우_예외() {
        // Given: 이름이 5글자가 넘는 입력 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("players,test");

        Input inputTest = new Input(new Validate(), inputGenerator);

        // When & Then : 5글자가 넘어간 이름 입력한 경우, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputTest.inputPlayers());
    }

    @Test
    public void Player_이름에_공백이_들어간_경우_예외() {
        // Given: 공백이 들어간 이름 입력
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("test,ab 2");

        Input inputTest = new Input(new Validate(), inputGenerator);

        // When & Then : 공백이 들어간 이름 입력한 경우, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputTest.inputPlayers());
    }

    @Test
    public void Player_빈_이름을_1개_입력_예외() {
        // Given
        // 빈 이름 입력
        InputGenerator inputOneGenerator = mock(InputGenerator.class);
        when(inputOneGenerator.readLine()).thenReturn("");

        Input inputOneTest = new Input(new Validate(), inputOneGenerator);

        // When & Then : 빈 이름을 1개 입력한 경우, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputOneTest.inputPlayers());
    }

    @Test
    public void Player_빈_이름을_여러개_입력_예외() {
        // Given
        // 빈 이름을 여러개 입력
        InputGenerator inputManyGenerator = mock(InputGenerator.class);
        when(inputManyGenerator.readLine()).thenReturn(",,,,");

        Input inputManyTest = new Input(new Validate(), inputManyGenerator);

        // When & Then : 빈 이름을 여러개 입력한 경우, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputManyTest.inputPlayers());
    }

    @Test
    public void 올바른_Player_입력() {
        // Given
        // 올바른 입력 "test1,test2,test3"
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("test1,test2,test3");

        Input inputNumberTest = new Input(new Validate(), inputGenerator);

        // When : inputPlayer 실행
        List<Player> result = inputNumberTest.inputPlayers();
        List<String> expectedNames = Arrays.asList("test1", "test2", "test3");

        // Then : 올바른 값 입력 검증
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(i).getName(), expectedNames.get(i));
        }
    }

    @Test
    public void 시도_횟수_문자열_입력_예외() {
        // Given
        // 문자열 입력 설정
        InputGenerator inputStringGenerator = mock(InputGenerator.class);
        when(inputStringGenerator.readLine()).thenReturn("str");

        Input inputNumberTest = new Input(new Validate(), inputStringGenerator);

        // When & Then : 시도 횟수에 문자열 입력 시, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputNumberTest.inputNumber());
    }

    @Test
    public void 시도_횟수_소수점_입력_예외() {
        // Given
        // 소수 입력 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("6.66");

        Input inputNumberTest = new Input(new Validate(), inputGenerator);

        // When & Then : 시도 횟수에 소수점 입력 시, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputNumberTest.inputNumber());
    }

    @Test
    public void 시도_횟수_음수값_입력_예외() {
        // Given
        // 음수 입력 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("-7");

        Input inputNumberTest = new Input(new Validate(), inputGenerator);

        // When & Then : 시도 횟수에 음수 입력 시, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputNumberTest.inputNumber());
    }

    @Test
    public void 시도_횟수_0_입력_예외() {
        // Given
        // 0 입력 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("0");

        Input inputNumberTest = new Input(new Validate(), inputGenerator);

        // When & Then : 시도 횟수에 0 입력 시, IllegalArgumentException 발생 검증
        assertThrows(IllegalArgumentException.class, () -> inputNumberTest.inputNumber());
    }

    @Test
    public void 시도_횟수가_올바르게_입력() {
        // Given
        // 올바른 입력 5 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("5");

        Input inputNumberTest = new Input(new Validate(), inputGenerator);

        // When : inputNumber 실행
        int result = inputNumberTest.inputNumber();
        int expected = 5;

        // Then : 올바른 값 입력 검증
        assertEquals(expected, result);
    }
}
