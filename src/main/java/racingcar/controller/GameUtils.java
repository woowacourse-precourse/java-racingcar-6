package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class GameUtils {
    public List<String> splitByComma(String userInput){
        return Arrays.asList(userInput.split(","));
    }
    public int makeRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4)
            return randomNumber;
        return 0;
    }
}
