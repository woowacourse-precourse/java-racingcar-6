package racingcar.domain.participant;

public class Participant {
    private Participant() {
        this.carName = "undefined";
    }

    protected Participant(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    private final String carName;
    private int distance;

    public String getCarName() {
        return this.carName;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }
}
