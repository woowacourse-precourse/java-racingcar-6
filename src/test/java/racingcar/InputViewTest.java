package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest extends NsTest {

    @DisplayName("사용자 입력 요구 메세지를 출력하는지")
    @Test
    void checkUserInputRequestMessage() {
        run("pobi, jun", "3");
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                "시도할 회수는 몇회인가요?");
    }

    @Override
    protected void runMain() {
        InputView.getCarNames();
        InputView.getRounds();
    }
}
