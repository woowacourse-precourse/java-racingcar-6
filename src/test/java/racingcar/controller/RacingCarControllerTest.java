package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
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
    private static final List<String> carNameList = List.of("pobi","woni","jun");
    private final InputHandler inputHandler = getInputHandler();
    private final RacingCarService racingCarService = getRacingCarService();
    private final RacingCarController racingCarController = new RacingCarController(inputHandler, new OutputView(), racingCarService);

    private RacingCarService getRacingCarService() {
        RacingCarService racingCarService = new RacingCarService(new RandomNumberProvider() {
            @Override
            public int getRandomNumber() {
                return moveForwardNumber;
            }
        });
        return racingCarService;
    }

    private InputHandler getInputHandler() {
        InputHandler inputHandler = new InputHandler(new InputConvertor(), new InputValidator(), new InputView() {
            @Override
            public String readCarNames() {
                return inputCarNames;
            }

            @Override
            public String readRaceTime() {
                return inputRaceTime;
            }
        });
        return inputHandler;
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
}