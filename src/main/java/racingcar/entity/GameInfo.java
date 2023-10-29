package racingcar.entity;

import java.util.List;

public class GameInfo {

    private List<String> participants;
    private int attemptTime;

    public GameInfo(List<String> participants, int attemptTime) {
        this.participants = participants;
        this.attemptTime = attemptTime;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public int getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(int attemptTime) {
        this.attemptTime = attemptTime;
    }
}
