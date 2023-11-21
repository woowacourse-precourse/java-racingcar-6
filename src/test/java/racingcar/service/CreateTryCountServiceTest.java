package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.TryCount;
import racingcar.validation.CarNameValidation;
import racingcar.validation.TryCountValidation;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

class CreateTryCountServiceTest {
    private final InputView inputView;
    private final OutputView outputView;
    private final CreateTryCountService createTryCountService;

    CreateTryCountServiceTest() {
        inputView = new InputView(new CarNameValidation(), new TryCountValidation());
        outputView = new OutputView();
        createTryCountService = new CreateTryCountService(inputView, outputView);
    }

    @BeforeEach
    void setup() {
        close();
    }

    @DisplayName("시도할 횟수 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5555"})
    void createCharacterTest(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        TryCount tryCount = createTryCountService.createTryCount();

        //then
        assertThat(tryCount.getTryCount()).isEqualTo(Integer.parseInt(input));
    }
}