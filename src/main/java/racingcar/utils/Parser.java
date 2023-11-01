package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> stringCarNameToArrayList (String playerInput){
        return new ArrayList<>(Arrays.asList(playerInput.split(",")));
    }

    public int stringAttemptNumToInt (String playerInputNum){
        return Integer.parseInt(playerInputNum);
    }
}
