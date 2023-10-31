package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.mock.MockInputView;
import racingcar.mock.MockOutputView;
import racingcar.mock.MockRacingCarGameFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameControllerTest {
    private static final RacingCarGameFactory racingCarGameFactory = new MockRacingCarGameFactory();

    private static final String RACING_CAR_NAME_INPUT = "semin,woowa,pre";
    private static final String ROUND_COUNT_INPUT = "5";

    private MockInputView mockInputView;
    private MockOutputView mockOutputView;
    private RacingCarGameController racingCarGameController;

    @BeforeEach
    void init() {
        mockInputView = (MockInputView) racingCarGameFactory.inputView();
        mockOutputView = (MockOutputView) racingCarGameFactory.outputView();
        racingCarGameController = racingCarGameFactory.racingCarController();
    }

    @Test
    void 게임_실행() {
        mockInputView.init(RACING_CAR_NAME_INPUT, ROUND_COUNT_INPUT);

        racingCarGameController.play();
        String printedMessage = mockOutputView.getPrintedMessageAndClear();

        assertThat(printedMessage)
                .contains("실행 결과", "semin", "woowa", "pre", "최종 우승자");
    }
}
