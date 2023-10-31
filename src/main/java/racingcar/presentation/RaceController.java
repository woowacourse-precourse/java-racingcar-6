package racingcar.presentation;

import static racingcar.global.constants.MessageType.FINAL_RESULT_MESSAGE;
import static racingcar.global.constants.MessageType.RESULT_MESSAGE;
import static racingcar.global.constants.MessageType.TOTAL_COUNT_REQUEST_MESSAGE;

import java.util.List;
import racingcar.application.RaceService;
import racingcar.domain.Cars;
import racingcar.view.View;

public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void startRace() {
        Cars cars = raceService.generateCars(View.requestCarNames());
        Integer count = raceService.generateCount(View.requestCount());
        play(cars, count);
        finish(cars);
    }

    private void play(Cars cars, Integer totalCount) {
        OutputView.printlnMessage(RESULT_MESSAGE.getMessage());
        for (int count = 0; count < totalCount; count++) {
            raceService.playRace(cars);
            OutputView.printlnMessage(cars.toString());
        }
    }

    private void finish(Cars cars) {
        List<String> winners = raceService.getWinners(cars);
        OutputView.printlnMessage(generateFinalResultMessage(winners));
    }

    private String generateFinalResultMessage(List<String> winners) {
        StringBuilder messageBuilder = new StringBuilder();
        for (String winner : winners) {
            messageBuilder.append(winner).append(FINAL_RESULT_TOKEN.getSymbol());
        }
        if (messageBuilder.length() > 0) {
            messageBuilder.setLength(messageBuilder.length() - FINAL_RESULT_TOKEN.getSymbol().length());
        }
        return String.format(FINAL_RESULT_MESSAGE.getMessage(), messageBuilder.toString());
    }
}
