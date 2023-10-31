package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Participants;
import racingcar.domain.ParticipantsFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ParticipantsFactory participantsFactory;

    public RacingCarController(InputView inputView, OutputView outputView, ParticipantsFactory participantsFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.participantsFactory = participantsFactory;
    }

    public void run() {
        Participants participants = createParticipants();
        playRace(participants);
        printWinner(participants);
    }

    private Participants createParticipants() {
        List<String> names = inputView.getNames();
        return participantsFactory.createFromName(names);
    }

    private void playRace(Participants participants) {
        int attemptCount = inputView.getAttemptCount();

        outputView.printRaceResultMessage();

        for (int i = 0; i < attemptCount; i++) {
            List<Car> cars = participants.race();
            outputView.printRaceResult(cars);
        }
    }

    private void printWinner(Participants participants) {
        List<String> winners = participants.getWinners();
        outputView.printWinners(winners);
    }
}
