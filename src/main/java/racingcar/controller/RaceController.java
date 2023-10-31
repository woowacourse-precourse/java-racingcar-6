package racingcar.controller;

import racingcar.dto.CarCondition;
import racingcar.dto.RaceResult;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public static final String NOT_NUMBER = "시도할 회수는 숫자를 입력해주세요";

    private static RaceController raceController;
    private static final RaceService raceService = RaceService.getInstance();

    public void start() {
        String carNames = InputView.takeNames();
        int count = toCount(InputView.takeCount());

        OutputView.sendResultStart();
        RaceResult raceResult = play(carNames, count);

        OutputView.sendWinners(raceResult);
    }

    private int toCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public RaceResult play(String carNames, int count) {
        raceService.initRace(carNames);

        while (count-- > 0) {
            CarCondition carCondition = raceService.proceed();
            OutputView.sendRaceCondition(carCondition);
        }

        return raceService.end();
    }

    public static RaceController getInstance() {
        if (raceController == null) {
            raceController = new RaceController();
        }
        return raceController;
    }

    private RaceController() {}
}
