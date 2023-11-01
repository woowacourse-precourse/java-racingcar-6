package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    void 자동차_이름_입력값_테스트(){
        String[] carNames = {"kkkk", "hhh", "jjjjjj"};
        assertThatThrownBy(() -> CheckValidation.validateName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 횟수_입력값_테스트(){
        String roundNum = "a";
        assertThatThrownBy(() -> CheckValidation.validateNum(roundNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 횟수_입력범위_제한_테스트(){
        String roundNum = "0";
        assertThatThrownBy(() -> CheckValidation.validateZero(roundNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
