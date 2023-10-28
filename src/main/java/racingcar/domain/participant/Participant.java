package racingcar.domain.participant;

public class Participant {
    protected Participant(String Name) {
        this.Name = Name;
        this.distance = 0;
    }

    private final String Name;
    private int distance;

    public String getName() {
        return this.Name;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }
}
