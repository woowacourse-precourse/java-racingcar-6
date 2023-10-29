package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Racing {

    NumberGenerator numberGenerator = new NumberGenerator();

    public String moveForward(int RandomNumber) {
        String count = "";
        if(RandomNumber > 3){
             count += "-";
        }
        return count;
    }

    public String moveResult(int attemptInput) {
        String result = "";
        for(int i=0; i<attemptInput; i++) {
            int randomNumber = numberGenerator.createRandomNumber();
            result += moveForward(randomNumber);
        }
        return result;
    }

}
