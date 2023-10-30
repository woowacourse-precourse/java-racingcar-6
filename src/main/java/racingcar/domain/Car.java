package racingcar.domain;

public interface Car {

    String getName();

    int getDistance();

    boolean isMaxDistance(int maxDistance);

    void attemptToMove();
}
