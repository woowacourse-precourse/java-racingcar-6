package racingcar.util.parser;

import racingcar.domain.participant.Participant;

import java.util.List;

public interface RaceResultParser {
    String parse(List<Participant> winners);
}
