package racingcar.service;

import racingcar.domain.participant.Participant;
import racingcar.domain.race.Race;

import java.util.List;

public interface RaceService {
    void validateCarName(String input);
    void validateRaceCount(String input);

    List<Participant> parseToParticipantList(String carNames);
    void runRace(List<Participant> participants);
    List<Participant> filterWinner(List<Participant> participants);
}
