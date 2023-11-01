package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame.GameExceptionUtil;

import static org.assertj.core.api.Assertions.*;

public class GameExceptionUtilTest {

    @Test
    void 유저_오류체크(){
        GameExceptionUtil gameExceptionUtil = new GameExceptionUtil();

        // 예외처리 테스트 정상작동 확인
        assertThatThrownBy(() -> gameExceptionUtil.checkUserNameLength("jabigi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자의 길이는 5를 넘을 수 없습니다.");
    }

    @Test
    void Iteration_입력오류체크(){
        GameExceptionUtil gameExceptionUtil = new GameExceptionUtil();

        // 예외처리 테스트 정상작동 확인
        assertThatThrownBy(() -> gameExceptionUtil.interationValidation("qskjs"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("적합하지 않은 숫자 형태입니다.");
    }
}
