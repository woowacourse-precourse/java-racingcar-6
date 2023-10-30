package racingcar;

public class RoundCountHandler implements UserInputHandler<Integer>{
    int roundCount;
    @Override
    public void handle(String stringRoundCount){
        try{
            roundCount = Integer.parseInt(stringRoundCount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Integer getHandledResult(){
        return roundCount;
    }
}
