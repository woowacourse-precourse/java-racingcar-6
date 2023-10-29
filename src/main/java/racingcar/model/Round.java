package racingcar.model;

public class Round {
    private int roundNum;
    public Round(){
        this.roundNum = 0;
    }

    public int getRoundNum() {
        return this.roundNum;
    }

    public void increaseRoundNum(){
        this.roundNum++;
    }
}