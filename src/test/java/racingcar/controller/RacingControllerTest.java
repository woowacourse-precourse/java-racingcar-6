package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.application.RacingService;
import racingcar.factory.CarFactory;
import racingcar.support.TestNumberGenerator;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static racingcar.enums.RacingConfig.MOVE_CONDITION;

class RacingControllerTest {
    private TestNumberGenerator generator;
    private InputView inputView;
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        generator = new TestNumberGenerator();
        inputView = mock(InputView.class);
        OutputView outputView = new OutputView();
        RacingService racingService = new RacingService(generator);
        CarFactory carFactory = new CarFactory();
        racingController = new RacingController(inputView, outputView, racingService, carFactory);
    }

    @Test
    void 모든_자동차가_멈추지_않고_전진한다() {
        // given
        generator.setReturnNumber(MOVE_CONDITION.getValue());
        doReturn("pobi,woni,jun").when(inputView).inputCarNames();
        doReturn("3").when(inputView).inputTryCount();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        racingController.run();

        // then
        assertThat(out.toString()).contains("pobi : ---", "woni : ---", "jun : ---", "최종 우승자 : pobi, woni, jun");
    }
}