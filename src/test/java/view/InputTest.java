package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

import racingcar.util.Validate;
import racingcar.view.Input;

public class InputTest {
    @Test
    void 자동차이름_입력() {
        Input inputView = new Input();
        String equalCars = "a,b,c";
        InputStream tempCars = new ByteArrayInputStream(equalCars.getBytes());
        String inputCars = null;

        // 자동차 이름을 a,b,c 입력
        try {
            System.setIn(tempCars);
            inputCars = inputView.promptForCarNames();

            // 입력한 값과 a,b,c와 같은지 확인
            assertThat(inputCars).isEqualTo(equalCars);
        } finally {
            Console.close();
        }
    }

    @Test
    void 전진_시도_위치정보() {
        Input inputView = new Input();
        String equalAttempt = "3";
        InputStream tempAttempt = new ByteArrayInputStream(equalAttempt.getBytes());
        String inputAttempt = null;

        try {
            // 시도 횟수를 3 입력
            System.setIn(tempAttempt);
            inputAttempt = inputView.promptForAttempts();

            // 입력한 값과 3이 같은지 확인
            assertThat(inputAttempt).isEqualTo(equalAttempt);
        } finally {
            Console.close();
        }
    }

    @Test
    void 자동차이름_마지막_쉼표_경우() {
        String comma = "test,test1,";

        assertThatThrownBy(() -> Validate.lastCharIsComma(comma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 : \",\" 뒤는 자동차 이름이 들어가야합니다.");
    }

    @Test
    void 구분자_쉼표_아닌_경우() {
        String delimiterNonComma = "김.정민.테스트";

        assertThatThrownBy(() -> Validate.inputStringNotContainsComma(delimiterNonComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 구분짓는 구분자는 쉼표(\",\")를 입력해야 합니다.");
    }

    @Test
    void 입력값_없을_경우() {
        String nullString = null;

        assertThatThrownBy(() -> Validate.inputIsNull(nullString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값을 확인해주세요");
    }

    @Test
    void 전진_시도_문자() {
        String move = "세번";

        assertThatThrownBy(() -> Validate.forwardIsNumericAndReturnInteger(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자여야 합니다.");
    }

    @Test
    void 전진_시도_음수() {
        int move = -1;

        assertThatThrownBy(() -> Validate.forwardIsPositiveNumber(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 숫자는 0보다 커야합니다.");
    }
}
