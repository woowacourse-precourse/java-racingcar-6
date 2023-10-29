package racingcar;

public class Game {

    private Cars cars;
    private Integer roundCount;

    public void setRoundCount(String userInput){
        roundCount = Integer.parseInt(userInput);
    }

    public Integer getRoundCount(){
        return roundCount;
    }
}
