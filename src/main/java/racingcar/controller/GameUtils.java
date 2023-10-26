package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameUtils {
    public List<String> splitByComma(String userInput){
        return Arrays.asList(userInput.split(","));
    }
}
