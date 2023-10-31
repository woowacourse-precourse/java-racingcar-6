package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutViewTest extends NsTest {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Test
    @DisplayName("printNameInputMessage 함수 기능 테스트")
    void 자동차_경주_게임_시작_시_메시지_출력_기능_테스트() {
        OutputView.printNameInputMessage();
        assertThat(output()).contains(NAME_INPUT_MESSAGE);
    }
    
    @Override
    protected void runMain() {

    }
}
