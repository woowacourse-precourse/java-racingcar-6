package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.handler.InputConvertor;
import racingcar.handler.InputHandler;
import racingcar.handler.InputValidator;
import racingcar.model.GameResult;
import racingcar.model.dto.CarProgressResponse;
import racingcar.service.RacingCarService;
import racingcar.service.random.RandomNumberProvider;
import racingcar.view.OutputView;
import racingcar.view.input.InputView;

class RacingCarControllerTest {
    private final String inputCarNames = "pobi,woni,jun";
    private final String inputRaceTime = "3";
    private static final int moveForwardNumber = 5;
    private static final List<String> carNameList = List.of("pobi", "woni", "jun");
    private final InputHandler inputHandler = getInputHandler();
    private final RacingCarService racingCarService = getRacingCarService();
    private final OutputView mockOutputView = mock(OutputView.class);
    private final RacingCarController racingCarController = new RacingCarController(inputHandler, mockOutputView, racingCarService);

    private RacingCarService getRacingCarService() {
        return new RacingCarService(new RandomNumberProvider() {
            @Override
            public int getRandomNumber() {
                return moveForwardNumber;
            }
        });
    }

    private InputHandler getInputHandler() {
        return new InputHandler(new InputConvertor(), new InputValidator(), new InputView() {
            @Override
            public String readCarNames() {
                return inputCarNames;
            }

            @Override
            public String readRaceTime() {
                return inputRaceTime;
            }
        });
    }

    @Test
    void gameStart() {
        GameResult gameResult = racingCarController.gameStart();
        final int racingTime = Integer.parseInt(inputRaceTime);
        assertAll(
            () -> assertThat(gameResult.winners()).isEqualTo(carNameList),
            () -> assertThat(gameResult.progressResponses().size()).isEqualTo(carNameList.size()),
            () -> {
                for (CarProgressResponse progressResponse : gameResult.progressResponses()) {
                    assertThat(progressResponse.result()).isEqualTo(racingTime);
                }
            }
        );
    }

    @Test
    void winnerDeclaration() {
        GameResult mockGameResult = mock(GameResult.class);
        final String name = "pobi";
        final int result = 3;

        when(mockGameResult.progressResponses()).thenReturn(List.of(new CarProgressResponse(name, result)));
        when(mockGameResult.winners()).thenReturn(List.of(name));

        racingCarController.winnerDeclaration(mockGameResult);

        verify(mockOutputView).printResultConsole(List.of(new CarProgressResponse(name, result)));
        verify(mockOutputView).printWinnerConsole(List.of(name));
    }
}
