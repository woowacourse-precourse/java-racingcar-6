package mytest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.Exception;

class ExceptionTest {

    @Test
    void 사용자_이름_5글자_초과시_예외_출력() {
        String[] userName = {"toolongname", "okay"};
        assertThatThrownBy(() -> Exception.checkOverWriteUserName(userName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("프로그램을 종료합니다.");
    }


    @Test
    void 게임횟수_글자포함_예외_출력(){
        String gameRoundNum = "a123";
        assertThatThrownBy(()->Exception.checkOnlyNumber(gameRoundNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("프로그램을 종료합니다.");
    }

    @Test
    void 게임횟수_제로_즉시_게임_종료(){
        String gameRoundNum = "0";
        assertThatThrownBy(()->Exception.ifUserZeroNumber(gameRoundNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("프로그램을 종료합니다.");
    }

}

