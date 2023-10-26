package racingcar.controller;

import java.util.List;
import racingcar.dto.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public static final String SEPARATOR = ",";
    public static final String NOT_NUMBER = "시도할 회수는 숫자를 입력해주세요";

    private static RaceController raceController;

    public void start() {
        List<String> carNames = toCarNames(InputView.takeNames());
        int count = toCount(InputView.takeCount());

        RaceResult raceResult = play(carNames, count);

        OutputView.sendRaceEnd();
        OutputView.sendWinners(raceResult);
    }

    private List<String> toCarNames(String input) {
        return List.of(input.split(SEPARATOR));
    }

    private int toCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public RaceResult play(List<String> carNames, int count) {
        return null;
    }

    public static RaceController getInstance() {
        if (raceController == null) {
            raceController = new RaceController();
        }
        return raceController;
    }

    private RaceController() {}
}
