package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

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
