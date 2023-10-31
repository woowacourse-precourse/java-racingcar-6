package racingcar.presentation;

import static racingcar.global.constants.SymbolType.*;

import java.util.List;
import racingcar.application.RaceService;
import racingcar.domain.Cars;
import racingcar.global.constants.SymbolType;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TOTAL_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "최종 우승자 : %s, %s";
    private final OutputView outputView;
    private final InputView inputView;
    private final RaceService raceService;

    public RaceController(OutputView outputView, InputView inputView, RaceService raceService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.raceService = raceService;
    }

    public void startRace() {
        outputView.printlnMessage(CAR_NAME_REQUEST_MESSAGE);
        Cars cars = raceService.generateCars(inputView.readCarNames());
        outputView.printlnMessage(TOTAL_COUNT_REQUEST_MESSAGE);
        Integer count = raceService.generateCount(inputView.readInput());
        play(cars, count);
        finish(cars);
    }

    private void play(Cars cars, Integer totalCount) {
        outputView.printlnMessage(RESULT_MESSAGE);
        for (int count = 0; count < totalCount; count++) {
            raceService.playRace(cars);
            outputView.printlnMessage(cars.toString());
        }
    }

    private void finish(Cars cars) {
        List<String> winners = raceService.getWinners(cars);
    }
}
