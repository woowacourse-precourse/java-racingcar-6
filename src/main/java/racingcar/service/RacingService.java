package racingcar.service;

import static racingcar.utils.NumberGernator.pickNumber;

import java.util.List;
import racingcar.domain.RaceParticipants;
import racingcar.domain.Round;
import racingcar.utils.PrintUtils;

public class RacingService {
    public void progress(RaceParticipants raceParticipants) {
        raceParticipants.getParticipantCars().forEach(car -> car.goForwardOrStop(pickNumber()));
    }

    public void startRound(RaceParticipants raceParticipants, Round round) {
        PrintUtils.printNewLine();
        PrintUtils.printOutputResult();
        while (!round.isFinished()) {
            progress(raceParticipants);
            List<String> carStatuses = raceParticipants.getRacingStatus();
            carStatuses.forEach(PrintUtils::print);
            round.finishOneRound();
            PrintUtils.printNewLine();
        }
    }
    public List<String> getWinner(RaceParticipants raceParticipants){
        return raceParticipants.getWinner();
    }

}
