package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Result result = new Result();

        String[] name = inputView.getCarNames();
        createParticipant(result, name);

        int num = inputView.getCount();
        result.setCount(num);

        outputView.race(result, name);
        outputView.getWinner(result.getParticipant());
    }

    private static void createParticipant(Result result, String[] name) {
        for (String n : name) {
            validateNameLength(n);
            result.putName(n);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) throw new IllegalArgumentException();
    }
}
