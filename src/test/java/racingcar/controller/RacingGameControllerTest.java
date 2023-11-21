package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.close;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;
import racingcar.service.CreateCharacterService;
import racingcar.service.CreateTryCountService;
import racingcar.service.RacingGameService;
import racingcar.validation.CarNameValidation;
import racingcar.validation.TryCountValidation;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

class RacingGameControllerTest extends NsTest {
    private final RacingGameController racingGameController;
    private final RacingGameService racingGameService;
    private final CreateCharacterService createCharacterService;
    private final CreateTryCountService createTryCountService;
    private final InputView inputView;
    private final OutputView outputView;


    RacingGameControllerTest() {
        inputView = new InputView(new CarNameValidation(), new TryCountValidation());
        outputView = new OutputView();
        racingGameService = new RacingGameService(inputView, outputView);
        createCharacterService = new CreateCharacterService(inputView, outputView);
        createTryCountService = new CreateTryCountService(inputView, outputView);
        racingGameController = new RacingGameController(racingGameService, createCharacterService,
                createTryCountService);
    }

    @BeforeEach
    void setup() {
        close();
    }

    @DisplayName("게임 시작 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "pobi, woni, jun; 5",
            "pobi, woni; 10"
    }, delimiter = ';')
    void gameStartTest(String carName, String tryCount) {
        //given
        String input = carName + "\n" + tryCount;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        racingGameController.GameStart();

        String output = output();
        int pobiCount = output.split("pobi : ").length - 1;
        int woniCount = output.split("woni : ").length - 1;

        //then
        Assertions.assertThat(pobiCount).isEqualTo(Integer.parseInt(tryCount));
        Assertions.assertThat(woniCount).isEqualTo(Integer.parseInt(tryCount));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}