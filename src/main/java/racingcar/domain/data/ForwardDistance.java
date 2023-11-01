package racingcar.domain.data;

import racingcar.constants.GameOption;

public class ForwardDistance {

    private int distance;

    public ForwardDistance() {
        this.distance = GameOption.START_FORWARD_DISTANCE;
    }

    public void increase() {
        distance++;
    }

    public int getValue() {
        return distance;
    }

    @Override
    public String toString() {
        return "-".repeat(distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ForwardDistance otherDistance = (ForwardDistance) obj;
        return distance == otherDistance.distance;
    }
}
