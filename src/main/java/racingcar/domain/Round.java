package racingcar.domain;

public class Round {
    private int totalRound;
    private int runningRound;
    public Round(int totalRound){
        this.totalRound = totalRound;
        this.runningRound = 0;
    }
    public void next(){
        this.runningRound += 1;
    }
    public boolean isEnd(){
        return this.totalRound > this.runningRound;
    }
}
