package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.GameInput;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("getInput: 정상 입력 처리에 성공한다")
    void getInput_정상입력() {
        String names = "a,b,c,d,e";
        String totalTurns = "10";

        ByteArrayInputStream input = new ByteArrayInputStream(String.join("\n", names, totalTurns).getBytes());
        System.setIn(input);

        GameInput gameInput = InputView.getInput();

        assertThat(gameInput.carNames()).containsExactly(names.split(","));
        assertThat(gameInput.totalTurns()).isEqualTo(Long.parseLong(totalTurns));

    }

    @Test
    @DisplayName("getInput: 빈 문자열이 입력되면 예외가 발생한다")
    void getInput_빈_문자열() {
        String names = "";
        String totalTurns = "10";

        ByteArrayInputStream input = new ByteArrayInputStream(String.join("\n", names, totalTurns).getBytes());
        System.setIn(input);
        assertThatThrownBy(InputView::getInput).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ILLEGAL_NAME.getMessage());
    }

    @Test
    @DisplayName("getInput: 이름으로 유효하지 않은 문자열이 입력되면 예외가 발생한다")
    void getInput_유효하지_않은_문자열() {
        String names = "a,     ,b";
        String totalTurns = "10";

        ByteArrayInputStream input = new ByteArrayInputStream(String.join("\n", names, totalTurns).getBytes());
        System.setIn(input);
        assertThatThrownBy(InputView::getInput).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ILLEGAL_NAME.getMessage());
    }

    @Test
    @DisplayName("getInput: 이름으로 빈 문자열이 입력되면 예외가 발생한다")
    void getInput_이름_형식_오류() {
        String names = "a,,b";
        String totalTurns = "10";

        ByteArrayInputStream input = new ByteArrayInputStream(String.join("\n", names, totalTurns).getBytes());
        System.setIn(input);
        assertThatThrownBy(InputView::getInput).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ILLEGAL_NAME.getMessage());
    }

    @Test
    @DisplayName("getInput: 게임 횟수가 0이상의 양수가 아니면 예외가 발생한다")
    void getInput_게임_횟수_오류() {
        String names = "a,b,c,d,e";
        String totalTurns = "-1";

        ByteArrayInputStream input = new ByteArrayInputStream(String.join("\n", names, totalTurns).getBytes());
        System.setIn(input);
        assertThatThrownBy(InputView::getInput).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ILLEGAL_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("getInput: 게임 횟수가 숫자 형식이 아닐 경우 예외가 발생한다")
    void getInput_게임_횟수_형식_오류() {
        String names = "a,b,c,d,e";
        String totalTurns = "1a3";

        ByteArrayInputStream input = new ByteArrayInputStream(String.join("\n", names, totalTurns).getBytes());
        System.setIn(input);
        assertThatThrownBy(InputView::getInput).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.ILLEGAL_NUMBER.getMessage());
    }
}