package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputViewTest extends NsTest {

    private final List<String> answer = Arrays.asList("pobi", "woni", "jun");
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("유저에게 입력받은 자동차 이륻들이 잘 들어오는지 테스트한다")
    void readCarNames() {
        super.run("pobi,woni,jun");
        assertThat(inputView.getCarNames())
                .isEqualTo(answer);
    }

    @Test
    @DisplayName("유저에게 입력받은 시도 횟수가 잘 들어오는지 테스트한다.")
    void readAttempts() {
        super.run("4");
        assertThat(inputView.getAttempts())
                .isEqualTo(4);
    }

    @Override
    protected void runMain() {

    }
}