package racingcar.model;

public interface Vehicle {
    void addScore();

    int getScore();

    String getName();

    void tryMove(int movePoint);

}
