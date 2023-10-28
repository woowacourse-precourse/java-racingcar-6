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
        String Names;
        String raceCount;
        List<Participant> participants;

        Names = console.getPlayerNames();
        raceService.validateName(Names);

        raceCount = console.getRaceCount();
        raceService.validateRaceCount(raceCount);

        participants = raceService.parseToParticipantList(Names);

        System.out.println();
        console.displayResultText();

        for ( int i = 0; i < Integer.parseInt( raceCount ); i++ ) {
            raceService.runRace(participants);
            participants.forEach(
                    p -> console.displayState(p.getName(), p.getDistance())
            );
            System.out.println();
        }

        List<Participant> winners = raceService.filterWinner(participants);
        console.displayWinner(winners);
    }
}
