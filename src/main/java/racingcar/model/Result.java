package racingcar.model;

import java.util.HashMap;

public class Result {
    private HashMap<String, Integer> participant;
    private int count;

    public Result() {
        participant = new HashMap<>();
    }

    public HashMap<String, Integer> getParticipant() {
        return participant;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void putName(String name) {
        participant.put(name, 0);
    }

    public void putScore(String name, int i) {
        participant.put(name, participant.get(name) + i);
    }

    public Integer getScore(String name) {
        return participant.get(name);
    }
}
