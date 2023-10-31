package racingcar.model;

public class GameRunCnt {
    private int runNumber;
    public void gameRunNumber(String num){
        validateType(num);
    }
    public int getRunNumber() {
        return this.runNumber;
    }
    public void validateType(String num){
        try{
            this.runNumber = Integer.parseInt(num);
        }
        catch (IllegalArgumentException e){

        }
    }
}
