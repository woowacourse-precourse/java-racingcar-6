package domain.gameInfo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.gameInfo.InputProgressCount;

public class InputProgressCountTest {
    @Test
    @DisplayName("문자열으로 입력된 입력 횟수가 숫자로 변환이 되었는 지 검증")
    public void 입력_횟수_스트링_숫자_변환_검증() throws Exception {
        InputProgressCount inputProgressCount = new InputProgressCount("5");
        Assertions.assertEquals(5, inputProgressCount.getProgressCount());
    }

    @Test
    @DisplayName("입력이 정수가 아닌 경우 예외 발생 검증")
    public void 문자열_입력_예외_검증() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new InputProgressCount("invalid"));
    }

    @Test
    @DisplayName("0보다 작은 입력이 들어오는 경우 예외 발생 검증")
    public void 범위를_초과하는_입력_예외_검증() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new InputProgressCount("0"));
    }

}
