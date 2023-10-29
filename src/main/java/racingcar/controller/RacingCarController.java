package racingcar.controller;

import java.util.List;
import racingcar.domain.Participants;
import racingcar.domain.RaceHistory;
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
        Participants participants = createParticipants();
        playRace(participants);
    }

    private Participants createParticipants() {
        List<String> names = inputView.getNames();
        return Participants.from(names);
    }

    private void playRace(Participants participants) {
        int attemptCount = inputView.getAttemptCount();
        RaceHistory raceHistory = participants.raceNTimes(attemptCount);
        outputView.printRaceHistory(raceHistory);
    }
}
