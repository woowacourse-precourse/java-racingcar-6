package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutViewTest extends NsTest {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    @Test
    @DisplayName("printNameInputMessage 함수 기능 테스트")
    void 자동차_경주_게임_시작_시_메시지_출력_기능_테스트() {
        OutputView.printNameInputMessage();
        assertThat(output()).contains(NAME_INPUT_MESSAGE);
    }

    @Test
    @DisplayName("printRoundInputMessage 함수 기능 테스트")
    void 시도_횟수_입력_메시지_출력_기능_테스트() {
        OutputView.printRoundInputMessage();
        assertThat(output()).contains(ROUND_INPUT_MESSAGE);
    }

    @Test
    @DisplayName("printExecutionResultMessage 함수 기능 테스트")
    void 실행_결과_메시지_출력_기능_테스트() {
        OutputView.printExecutionResultMessage();
        assertThat(output()).contains(
                EXECUTION_RESULT_MESSAGE);
    }

    @Override
    protected void runMain() {

    }
}
