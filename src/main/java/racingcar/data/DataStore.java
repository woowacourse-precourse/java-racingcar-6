package racingcar.data;

import racingcar.domain.ExtractTrack;
import racingcar.domain.Participants;

public class DataStore {

    private ExtractTrack extractTrack;
    private Participants participants;


    public ExtractTrack saveExtractTrack(ExtractTrack extractTrack) {
        return this.extractTrack = extractTrack;
    }

    public Participants saveParticipants(Participants participants) {
        return this.participants = participants;
    }


    public ExtractTrack findExtractTrack() {
        return extractTrack;
    }

    public Participants findParticipants() {
        return participants;
    }
}
