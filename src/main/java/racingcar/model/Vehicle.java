package racingcar.model;

public interface Vehicle {
    void addWinScore();

    int getWinScore();

    String getName();

    void tryMove(int movePoint);

}
