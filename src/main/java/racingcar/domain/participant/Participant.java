package racingcar.domain.participant;

public class Participant {
    protected Participant(String name) {
        this.name = name;
        this.distance = 0;
    }

    private final String name;
    private int distance;

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }
}
