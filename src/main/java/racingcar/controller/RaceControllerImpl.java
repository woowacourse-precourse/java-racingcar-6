package racingcar.controller;

import racingcar.console.Console;
import racingcar.domain.participant.Participant;
import racingcar.service.RaceService;

import java.util.List;

public class RaceControllerImpl implements RaceController {
    public RaceControllerImpl(Console console, RaceService raceService) {
        this.console = console;
        this.raceService = raceService;
    }
    private final Console console;
    private final RaceService raceService;

    @Override
    public void run() {
        String carNames;
        String raceCount;
        List<Participant> participants;

        carNames = console.getPlayerCarNames();
        raceService.validateCarName(carNames);

        raceCount = console.getRaceCount();
        raceService.validateRaceCount(raceCount);

        participants = raceService.parseToParticipantList(carNames);

        System.out.println();
        console.displayResultText();

        for ( int i = 0; i < Integer.parseInt( raceCount ); i++ ) {
            raceService.runRace(participants);
            participants.forEach(
                    p -> console.displayState(p.getCarName(), p.getDistance())
            );
            System.out.println();
        }

        List<Participant> winners = raceService.filterWinner(participants);
        console.displayWinner(winners);
    }
}
