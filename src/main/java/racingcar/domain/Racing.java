package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {

    NumberGenerator numberGenerator = new NumberGenerator();

    public Boolean isMoveCondition() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= 4;
    }

    public String[] moveResult(List<String> cars,String[] raceResult) {
        for(int i=0; i<cars.size(); i++) {
            if(raceResult[i] == null){
                raceResult[i] = "";
            }
          moveForward(raceResult,i);
        }
        return raceResult;
    }

    public void moveForward(String[] raceResult,int index) {
        if(isMoveCondition()){
            raceResult[index] += "-";
        }
    }

}
