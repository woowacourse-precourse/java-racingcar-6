package racingcar.model;

public class RemainRacingCount {

    private int remainRacingCount;

    public RemainRacingCount(int remainRacingCount){
        this.remainRacingCount=remainRacingCount;
    }

    public void minusRemainRacingCount(){
        remainRacingCount-=1;
    }

    public boolean isRemainRacingCount(){
        if(remainRacingCount==0){
            return false;
        }
        else if(remainRacingCount>0){
            return true;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getRemainRacingCount(){ //  테스트용 코드
        return remainRacingCount;
    }
}
