package racingcar.domain;

public class Racer {
    private String racerName;
    private int currentMove = 0;


    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove() {
        this.currentMove++;
    }
}
