package racingcar.data;

import racingcar.domain.ExtractTrack;
import racingcar.domain.Participants;

public class RacingCarRepository {

    private ExtractTrack extractTrack;
    private Participants participants;


    public void save(ExtractTrack extractTrack) {
        this.extractTrack = extractTrack;
    }

    public void save(Participants participants) {
        this.participants = participants;
    }


    public ExtractTrack findExtractTrack() {
        return extractTrack;
    }

    public Participants findParticipants() {
        return participants;
    }

}
