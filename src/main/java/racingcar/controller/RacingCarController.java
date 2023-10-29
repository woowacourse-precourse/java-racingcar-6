package racingcar.controller;

import java.util.List;
import racingcar.domain.Participants;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        createParticipants();
    }

    private Participants createParticipants() {
        List<String> names = inputView.getNames();
        return Participants.from(names);
    }
}
