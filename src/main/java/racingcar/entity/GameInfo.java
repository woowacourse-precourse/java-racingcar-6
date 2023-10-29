package racingcar.entity;

import java.util.List;

public class GameInfo {

    private List<Participant> participants;
    private int attemptTime;

    public GameInfo(List<Participant> participants, int attemptTime) {
        this.participants = participants;
        this.attemptTime = attemptTime;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public int getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(int attemptTime) {
        this.attemptTime = attemptTime;
    }
}
