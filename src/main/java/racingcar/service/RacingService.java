package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.RaceParticipants;
import racingcar.domain.Round;
import racingcar.utils.PrintUtils;

public class RacingService {
    public static final int NUM_RANGE = 10;


    public void progress(RaceParticipants raceParticipants) {
        raceParticipants.getParticipantCars().forEach(car -> car.goForwardOrStop(pickNumber()));
    }

    public int pickNumber(){
        return Randoms.pickNumberInRange(0,9);
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
