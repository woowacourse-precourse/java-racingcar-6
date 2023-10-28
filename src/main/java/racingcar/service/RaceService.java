package racingcar.service;

import racingcar.domain.participant.Participant;

import java.util.List;

public interface RaceService {
    void validateName(String input);
    void validateRaceCount(String input);
    List<Participant> parseToParticipantList(String input);
    void runRace(List<Participant> participants);
    List<Participant> filterWinner(List<Participant> participants);
}
