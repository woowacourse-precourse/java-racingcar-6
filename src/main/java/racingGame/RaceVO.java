package racingGame;

public class RaceVO {
    private String carName;
    private int goalCnt;

    RaceVO(String carName, int goalCnt) {
        this.carName = carName;
        this.goalCnt = goalCnt;
    }

    public String getCarName() {
        return carName;
    }

    public int getGoalCnt() {
        return goalCnt;
    }

    public void upGoalCnt() {
        this.goalCnt++;
    }
}
