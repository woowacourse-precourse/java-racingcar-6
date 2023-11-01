package racingcar;

public class TurnCounter {
    int turns;
    public TurnCounter(int turns){
        if(!(turns>0)){
            throw new IllegalArgumentException("시도 횟수는 자연수를 사용해 주세요");
        }
        this.turns = turns;
    }

    public int getTurns() {
        return turns;
    }
    public boolean next(){
        if(turns==0){
            return false;
        }
        turns -= 1;
        return true;
    }
}