package racingcar.domain.participant;

public class Participant {
    private final String DEFAULT_NAME = "(undefined)";

    private Participant() {
        this.carName = DEFAULT_NAME;
    }

    protected Participant(String carName) {
        if ( carName.isEmpty() )
            this.carName = DEFAULT_NAME;
        else this.carName = carName;
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
