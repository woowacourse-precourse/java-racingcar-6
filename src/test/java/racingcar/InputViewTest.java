package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 플레이어_이름_입력_확인() {
        String simulatedInput = "aaa";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 테스트 실행
        List<String> validPlayerList = inputView.inputPlayerList();
        assertThat(validPlayerList).containsExactly("aaa");
    }

    @Test
    void 플레이어_이름_길이_예외_처리() {
        String simulatedInput = "aaaa,aaaaaa,aaa";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 테스트 실행
        assertThatThrownBy(() -> inputView.inputPlayerList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어의 이름은 5글자 이하이어야 합니다.");
    }

    @Test
    void 플레이어_이름_공백_처리() {
        String simulatedInput = "\n";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 테스트 실행
        assertThatThrownBy(() -> inputView.inputPlayerList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한명 이상의 플레이어를 입력해야합니다.");
    }

    @Test
    void 게임_횟수_입력_확인() {
        String simulatedInput = "12";

        // System.in 재지정
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 테스트 실행
        int validGameCount = inputView.inputGameCount();
        assertThat(validGameCount).isEqualTo(12);
    }

    @Test
    void 게임_횟수_숫자외_예외_처리() {
        String simulatedInput = "123a";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 테스트 실행
        assertThatThrownBy(() -> inputView.inputGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수는 1이상의 정수이어야합니다.");
    }

    @Test
    void 게임_횟수_1미만_예외_처리() {
        String simulatedInput = "0000";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 테스트 실행
        assertThatThrownBy(() -> inputView.inputGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수는 1이상의 정수이어야합니다.");
    }
}

