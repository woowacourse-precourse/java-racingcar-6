package view;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.Application;
import racingcar.view.OutputView;
import racingcar.message.ViewMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.Arrays;
import java.util.List;

class OutputViewTest extends NsTest {
    private static final String RUNRESULT = "pobi : ---";
    private static final String WINNER = "최종 우승자 : pobi";

    @DisplayName("print_자동차_이름을_입력하세요")
    @Test
    void print_자동차_이름을_입력하세요() {
        OutputView outputView = new OutputView();
        outputView.printNameMessage();

        assertThat(output()).isEqualTo(ViewMessage.PRINT_NAME);
    }

    @DisplayName("print_회수를_입력하세요")
    @Test
    void print_회수를_입력하세요() {
        OutputView outputView = new OutputView();
        outputView.printTryNumberMessage();

        assertThat(output()).isEqualTo(ViewMessage.PRINT_TRY_NUMBER);
    }

    @DisplayName("print_실행_결과_문구")
    @Test
    void print_실행_결과_문구() {
        OutputView outputView = new OutputView();
        outputView.printRunResultMessage();

        assertThat(output()).isEqualTo(ViewMessage.PRINT_RUN_RESULT);
    }

    @DisplayName("print_실행_결과")
    @Test
    void print_실행_결과() {
        OutputView outputView = new OutputView();
        outputView.printRunResult("pobi",3);

        assertThat(output()).isEqualTo(RUNRESULT);
    }

    @DisplayName("print_최종_우승자")
    @Test
    void print_최종_우승자() {
        OutputView outputView = new OutputView();
        outputView.printWinner(List.of("pobi"));

        assertThat(output()).isEqualTo(WINNER);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
