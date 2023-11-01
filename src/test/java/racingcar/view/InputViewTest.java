package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.IllegalArgumentExceptionType;

class InputViewTest {

    InputView inputView = new InputView();

    void setUp(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }


    @Test
    void 차량이름_입력_성공_테스트() {
        String carName1 = "pobi";
        String carName2 = "woni";
        String carName3 = "jyk";
        String[] carNames = new String[]{carName1, carName2, carName3};

        String[] args = new String[]{String.join(", ", carNames)};
        setUp(args);

        assertThat(inputView.readCarNames())
                .containsExactly(carName1, carName2, carName3)
                .isInstanceOf(List.class)
                .hasSize(carNames.length);
    }

    @Test
    void 시도횟수_입력_성공_테스트() {
        int three = 3;
        setUp(new String[]{"" + three});

        assertThat(inputView.readAttemptCount()).isEqualTo(three);
    }

    @Test
    void 시도횟수_입력_실패_테스트() {
        String koreanThree = "삼";
        setUp(new String[]{koreanThree});
        IllegalArgumentException exception = IllegalArgumentExceptionType
                .PARSE_INT_ERROR_MESSAGE
                .getException();

        assertThatThrownBy(() -> inputView.readAttemptCount())
                .isInstanceOf(exception.getClass())
                .hasMessage(exception.getMessage());
    }
}


