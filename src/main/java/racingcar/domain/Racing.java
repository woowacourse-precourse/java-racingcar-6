package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {

    NumberGenerator numberGenerator = new NumberGenerator();

    public String moveForward(int RandomNumber) {
        String count = "";
        if(RandomNumber > 3){
             count += "-";
        }
        return count;
    }

    public String[] moveResult(List<String> cars,String[] raceResult) {
        for(int i=0; i<cars.size(); i++) {
            if(raceResult[i] == null){
                raceResult[i] = "";
            }
            int randomNumber = numberGenerator.createRandomNumber();
            raceResult[i] += moveForward(randomNumber);
        }
        return raceResult;
    }

}
